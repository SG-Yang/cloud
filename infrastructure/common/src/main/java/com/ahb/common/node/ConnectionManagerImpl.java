package com.ahb.common.node;

import com.ahb.common.Conf;
import com.ahb.common.exchange.*;
import com.google.common.collect.Maps;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.util.Map;
import java.util.UUID;

/**
 * Created by aheroboy on 9/3/2018.
 */
public class ConnectionManagerImpl implements ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManagerImpl.class);
    private Axis connectAxis;
    private TServer tServer;
    private ExchangeService.Processor tProcessor;
    private ExchangeService.Iface handler;
    private Thread serveThread;
    private static final Map<String, Integer> JOIN_REQUESTS = Maps.newHashMap();

    enum CMHolder {
        INSTANCE;
        ConnectionManagerImpl connectionManager;

        CMHolder() {
            connectionManager = new ConnectionManagerImpl();
        }
    }

    private ConnectionManagerImpl() {
    }

    public void buildConnectionManager() {
        try {
            Node node = NodeImpl.NodeHolder.INSTANCE.getNode();
            Conf conf = node.getConf();
            handler = new ExchangeHandler(conf);
            TNonblockingServerTransport nonblockingServerTransport = new TNonblockingServerSocket(conf.getPort());
            tProcessor = new ExchangeService.Processor(handler);
            tServer = new TNonblockingServer(new TNonblockingServer.Args(nonblockingServerTransport).processor(tProcessor));

            NodeInfo nodeInfo;
            JoinResp resp = null;
            if (!conf.isCenterNode()) {
                //Request join
                resp = requestJoin();
                nodeInfo = new NodeInfo(resp.getTarget());
            } else {
                nodeInfo = new NodeInfo(new NodeId(0, 0, 0, conf.getIp(), conf.getPort()));
            }
            node.setNodeInfo(nodeInfo);

            connectAxis = new Axis(new SelfCloudManager(node));
            if (resp != null) {
                NodeInfo joinerInfo = new NodeInfo(resp.getJoiner());
                CloudManager cloudManager = new ProxyCloudManager(joinerInfo);

                //Do join.
                JoinReq req = new JoinReq();
                ExchangeInfo exchangeInfo = ExchangeInfoBuilder.newInstance()
                        .ofFromNode(nodeInfo.toNodeAxis())
                        .ofEType(ExchangeType.JOIN)
                        .ofToken(resp.getExInfo().getToken())
                        .build();
                req.setExInfo(exchangeInfo);
                cloudManager.doJoin(req);

                //Clean up join token.
                NodeAxis initNode = this.connectAxis.getSelf().getNodeInfo().toNodeAxis();
                ExchangeInfo cleanInfo = ExchangeInfoBuilder.newInstance()
                        .ofFromNode(initNode)
                        .ofInitNode(initNode)
                        .ofToken(resp.getExInfo().getToken())
                        .ofEType(ExchangeType.CLEAN_TOKEN)
                        .ofStep(0)
                        .build();
                cloudManager.cleanToken(cleanInfo);

                connectAxis.add(joinerInfo.getNodeId(), cloudManager);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void serve() {
        serveThread = new Thread(() -> tServer.serve());
        serveThread.start();
    }

    public void setAxis(Axis axis) {
        this.connectAxis = axis;
    }

    class ExchangeHandler implements ExchangeService.Iface, ExchangeService.AsyncIface {
        private Conf conf;

        public ExchangeHandler(Conf conf) {
            this.conf = conf;
        }

        @Override
        public void exchange(ExchangeInfo input, AsyncMethodCallback<ExchangeInfo> resultHandler) throws TException {
            try {
                resultHandler.onComplete(exchange(input));
            } catch (Exception e) {
                resultHandler.onError(e);
            }
        }

        @Override
        public void requestJoin(JoinReq req, AsyncMethodCallback<JoinResp> resultHandler) throws TException {
            try {
                JoinResp resp = requestJoin(req);
                resultHandler.onComplete(resp);
            } catch (Exception e) {
                resultHandler.onError(e);
            }
        }

        @Override
        public ExchangeInfo exchange(ExchangeInfo input) throws TException {
            switch (input.getEType()) {
                case HEARTBEAT:
                    System.out.println("heart beat received " + input.getFromNode() + input.getToken());
                    return input;
                default:
            }
            return null;
        }

        @Override
        public JoinResp requestJoin(JoinReq req) throws TException {
            System.out.println("Exchanging info..." + req);
            synchronized (JOIN_REQUESTS) {
                String requestToken = req.getExInfo().getToken();
                Integer reqCnt = JOIN_REQUESTS.get(requestToken);
                if (reqCnt != null) {
                    reqCnt++;
                    JOIN_REQUESTS.put(requestToken, reqCnt);
                    JoinResp ignoreResp = new JoinResp();

                    ExchangeInfo exchangeInfo = ExchangeInfoBuilder.newInstance()
                            .ofToken(req.getExInfo().getToken())
                            .ofEType(ExchangeType.IGNORE)
                            .build();

                    ignoreResp.setExInfo(exchangeInfo);
                    System.out.println("Ignore request for " + req);
                    return ignoreResp;
                } else {
                    reqCnt = new Integer(1);
                    JOIN_REQUESTS.put(requestToken, reqCnt);
                }
            }
            JoinResp availableNode = connectAxis.getSelf().requestJoin(req);
            if (availableNode != null) {
                return availableNode;
            } else {
                return broadcast(req);
            }
        }

        @Override
        public JoinResp doJoin(JoinReq req) throws TException {
            return connectAxis.getSelf().doJoin(req);
        }

        private void doCleanToken(String token) {
            synchronized (JOIN_REQUESTS) {
                JOIN_REQUESTS.remove(token);
            }
        }

        @Override
        public void doJoin(JoinReq req, AsyncMethodCallback<JoinResp> resultHandler) throws TException {
            try {
                resultHandler.onComplete(doJoin(req));
            } catch (Exception e) {
                resultHandler.onError(e);
            }
        }

        @Override
        public void cleanToken(ExchangeInfo exchangeInfo) throws TException {
            System.out.println("Token clean up " + exchangeInfo);
            doCleanToken(exchangeInfo.getToken());
            connectAxis.getNeighbors().stream().filter((
                    CloudManager cloudManager) -> {
                //Not resolve back to the from node.
                NodeId nodeId = cloudManager.getNodeInfo().getNodeId();
                if (nodeId.equals(NodeInfo.toNodeId(exchangeInfo.getFromNode()))
                        || nodeId.equals(NodeInfo.toNodeId(exchangeInfo.getInitNode()))) {
                    return Boolean.FALSE;
                }
                NodeAxis fromAxis = exchangeInfo.getFromNode();
                NodeAxis selfAxis = connectAxis.getSelf().getNodeInfo().toNodeAxis();
                //Init, will distributor to all 3 dimentions.
                if (exchangeInfo.getStep() == 0) {
                    return Boolean.TRUE;
                }
                //(x,y not change), move on z direction, will resolve to all.
                if (fromAxis.getXAxis() == selfAxis.getXAxis()
                        && fromAxis.getYAxis() == selfAxis.getYAxis()
                        && (fromAxis.getZAxis() + 1) == selfAxis.getZAxis()) {
                    return Boolean.TRUE;
                }

                //(y,z not change),move on x direction, will resolve to both x,y
                if (fromAxis.getYAxis() == selfAxis.getYAxis()
                        && fromAxis.getZAxis() == selfAxis.getZAxis()
                        && (fromAxis.getXAxis() + 1) == selfAxis.getXAxis()
                        && selfAxis.getZAxis() == nodeId.getZ()) {
                    return Boolean.TRUE;
                }
                //(x,z not change), move on y direction, will distributor to y only.
                if (fromAxis.getXAxis() == selfAxis.getXAxis()
                        && fromAxis.getZAxis() == selfAxis.getZAxis()
                        && (fromAxis.getYAxis() + 1) == selfAxis.getYAxis()
                        && selfAxis.getZAxis() == nodeId.getZ()
                        && selfAxis.getXAxis() == nodeId.getX()) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            })
                    .forEach((CloudManager cloudManager) -> {
                        try {
                            exchangeInfo.setFromNode(connectAxis.getSelf().getNodeInfo().toNodeAxis());
                            exchangeInfo.setStep(exchangeInfo.getStep() + 1);
                            cloudManager.cleanToken(exchangeInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    });
        }

        @Override
        public void cleanToken(ExchangeInfo exchangeInfo, AsyncMethodCallback<Void> resultHandler) throws TException {
            try {
                cleanToken(exchangeInfo);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public JoinResp requestJoin() {
        Conf conf = NodeImpl.NodeHolder.INSTANCE.getNode().getConf();
        try {
            ExchangeService.Client client = ClientBuilder.getBuilder().ofHost(Node.CENTOER_NODE_IP).ofPort(Node.CENTOER_NODE_PORT).build();

            NodeAxis axis = NodeAxisBuilder.newInstance().ofIP(Inet4Address.getLocalHost().getHostAddress())
                    .ofPort(conf.getPort()).build();
            ExchangeInfo exInfo = ExchangeInfoBuilder.newInstance()
                    .ofEType(ExchangeType.JOIN)
                    .ofFromNode(axis)
                    .ofInitNode(axis)
                    .ofToken(UUID.randomUUID().toString())
                    .build();

            return client.requestJoin(new JoinReq(exInfo));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exit() {

    }

    private JoinResp broadcast(JoinReq req) {
        return connectAxis.getNeighbors()
                .stream()
                .filter((CloudManager cloudManager) -> !cloudManager.getNodeInfo().getNodeId().equals(NodeInfo.toNodeId(req.getExInfo().getFromNode())))
                .map((CloudManager cloudManager) -> {
                    try {
                        return cloudManager.requestJoin(req);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter((JoinResp result) -> result != null || !ExchangeType.IGNORE.equals(result.getExInfo().getEType()))
                .min((JoinResp r1, JoinResp r2) -> {
                    NodeAxis r1Axis = r1.getTarget();
                    NodeAxis r2Axis = r2.getTarget();
                    double r1Line = Math.sqrt(Math.pow(r1Axis.getXAxis(), 2) + Math.pow(r1Axis.getYAxis(), 2) + Math.pow(r1Axis.getZAxis(), 2));
                    double r2Line = Math.sqrt(Math.pow(r2Axis.getXAxis(), 2) + Math.pow(r2Axis.getYAxis(), 2) + Math.pow(r2Axis.getZAxis(), 2));
                    if (r1Line > r2Line) return -1;
                    else if (r1Line == r2Line) return 0;
                    else return 1;
                })
                .get();

    }

    private void processMissing() {
        //TODO: handle missed neighbors.
    }

    @Override
    public boolean areNeighborsAlive() {
        for (CloudManager neighbor : connectAxis.getNeighbors()) {
            if (neighbor != null) {
                try {
                    ExchangeInfo exchangeInfo = new ExchangeInfo();
                    NodeAxis from = new NodeAxis();
                    NodeId fromNodeId = connectAxis.getSelf().getNodeInfo().getNodeId();
                    from.setPort(fromNodeId.getPort());
                    from.setIp(fromNodeId.getIp());
                    from.setXAxis(fromNodeId.getX());
                    from.setYAxis(fromNodeId.getY());
                    from.setZAxis(fromNodeId.getZ());

                    exchangeInfo.setFromNode(from);
                    exchangeInfo.setToken(UUID.randomUUID().toString());
                    exchangeInfo.setEType(ExchangeType.HEARTBEAT);
                    ExchangeInfo res = neighbor.exchange(exchangeInfo);
                    if (res == null) {
                        return Boolean.FALSE;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    processMissing();
                    return false;
                }
            }

        }
        return Boolean.TRUE;
    }
}
