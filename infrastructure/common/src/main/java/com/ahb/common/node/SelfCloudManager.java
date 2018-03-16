package com.ahb.common.node;

import com.ahb.common.exchange.*;
import org.apache.thrift.TException;

/**
 * Created by aheroboy on 12/3/2018.
 */
public class SelfCloudManager implements CloudManager {
    private Node node;
    private Axis axis;

    public SelfCloudManager(Node node) {
        this.node = node;
    }

    @Override
    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    @Override
    public NodeInfo getNodeInfo() {
        return node.getNodeInfo();
    }

    @Override
    public ExchangeInfo exchange(ExchangeInfo input) throws TException {
        return null;
    }

    @Override
    public JoinResp requestJoin(JoinReq req) throws TException {
        NodeInfo availableNode = axis.getAvailable();
        if (availableNode == null) {
            return null;
        }
        NodeAxis target = NodeAxisBuilder.newInstance().ofXAxis(availableNode.getNodeId().getX())
                .ofYAxis(availableNode.getNodeId().getY())
                .ofZAxis(availableNode.getNodeId().getZ())
                .ofIP(req.getExInfo().getInitNode().getIp())
                .ofPort(req.getExInfo().getInitNode().getPort())
                .build();

        NodeAxis joiner = this.getNodeInfo().toNodeAxis();

        ExchangeInfo exchangeInfo = ExchangeInfoBuilder.newInstance()
                .ofEType(ExchangeType.RESP)
                .ofToken(req.getExInfo()
                .getToken())
                .ofFromNode(joiner)
                .build();

        return new JoinResp(exchangeInfo, target, joiner);
    }

    void accept(NodeAxis target) {
        axis.add(NodeInfo.toNodeId(target), new ProxyCloudManager(target));
    }

    @Override
    public JoinResp doJoin(JoinReq req) throws TException {
        NodeAxis fromNode = req.exInfo.getFromNode();
        accept(fromNode);
        ExchangeInfo exchangeInfo = new ExchangeInfo();
        exchangeInfo.setEType(ExchangeType.RESP);
        exchangeInfo.setToken(req.getExInfo().getToken());
        JoinResp resp = new JoinResp();
        resp.setExInfo(exchangeInfo);
        return resp;
    }

    @Override
    public void cleanToken(ExchangeInfo token) throws TException {

    }
}
