package com.ahb.common.node;

import com.ahb.common.Conf;
import com.ahb.common.ConfImpl;
import com.ahb.common.region.Store;
import com.ahb.common.region.StoreImpl;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.ahb.common.web.WebEngin;
import com.ahb.common.web.WebEngineImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by aheroboy on 9/3/2018.
 */
public class NodeImpl implements Node {
    protected static final Logger LOGGER = LoggerFactory.getLogger(NodeImpl.class);
    private ConnectionManager connectionManager;
    private WebEngin webEngin;
    private AtomicReference<RunState> state = new AtomicReference<>();
    private Thread monitor;
    private Thread heartBeat;
    private Conf conf;
    private NodeInfo nodeInfo;
    private RegionManager regionManager;
    private Store store;
    private volatile boolean isAPIServer = Boolean.FALSE;

    private NodeImpl(Conf conf) {
        this.conf = conf;
        isAPIServer = Boolean.valueOf(conf.getServerType());
    }

    public enum NodeHolder {
        INSTANCE;
        private NodeImpl node;

        NodeHolder() {
            Conf conf = new ConfImpl();
            node = new NodeImpl(conf);
        }

        public Node getNode() {
            return node;
        }
    }

    public static Node newInstance() {
        return NodeHolder.INSTANCE.getNode();
    }

    @Override
    public void distribute(InternalReq req, InternalResp resp) {
        regionManager.getDistributor(req.getRegionUrl()).distribute(req, resp);
    }

    @Override
    public void start() throws Exception {
        init();
        LOGGER.info("Server start at :" + this.getNodeInfo().getNodeId());
        if (isAPIServer) {
            webEngin.start();
        }
        monitor.start();
        heartBeat.start();
    }

    private synchronized void init() {
        try {
            state.set(RunState.INIT);
            initConnectionManager();
            initStore();
            initRegionManger();
            initWebEngine();
            initMonitors();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        } finally {
            state.set(RunState.RUNNING);
        }
    }

    private void initStore() {
        store = StoreImpl.StoreHolder.INSTANCE.store;
    }

    private void initMonitors() {
        monitor = new Thread(() -> {
            while (state.get().equals(RunState.RUNNING)) {
                //System.out.println(Thread.currentThread().getName() + " Running");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LOGGER.info("Server stopped.....");
        }, String.join(":", new String[]{conf.getIp(), conf.getPort() + ""}));

        heartBeat = new Thread(() -> {
            //TODO: send heart beat event.
            while (state.get().equals(RunState.RUNNING)) {
                try {
                    connectionManager.areNeighborsAlive();
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initWebEngine() {
        if (isAPIServer) {
            webEngin = new WebEngineImpl();
        }
    }

    private void initConnectionManager() {
        connectionManager = ConnectionManagerImpl.CMHolder.INSTANCE.connectionManager;
        connectionManager.buildConnectionManager();
        connectionManager.serve();
    }

    private void initRegionManger() {
        regionManager = new RegionManagerImpl();
        regionManager.init();
    }

    @Override
    public void setNodeInfo(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    @Override
    public void stop() {
        state.set(RunState.STOPED);
    }

    @Override
    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    @Override
    public Conf getConf() {
        return this.conf;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStarting() {
        return false;
    }

    @Override
    public boolean isStopping() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }
}

