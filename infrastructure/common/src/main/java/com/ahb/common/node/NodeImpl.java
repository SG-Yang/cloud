package com.ahb.common.node;

import com.ahb.common.Conf;
import com.ahb.common.ConfImpl;
import com.ahb.common.monitor.MonitorManager;
import com.ahb.common.region.RegionRoute;
import com.ahb.common.region.RegionRouteImpl;
import com.ahb.common.store.Store;
import com.ahb.common.store.StoreImpl;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.ahb.common.web.WebEngine;
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
    private WebEngine webEngine;
    private AtomicReference<RunState> state = new AtomicReference<>();
    private Conf conf;
    private NodeInfo nodeInfo;
    private RegionRoute regionRoute;
    private MonitorManager monitorManager;
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
        regionRoute.distribute(req, resp);
    }

    @Override
    public void start() throws Exception {
        init();
        LOGGER.info("Server start at :" + this.getNodeInfo().getNodeId());
        if (isAPIServer) {
            webEngine.start();
        }
        connectionManager.start();
        store.start();
        regionRoute.start();
        monitorManager.start();
    }

    public synchronized void init() {
        try {
            state.set(RunState.INIT);
            initConnectionManager();
            initStore();
            initRegionManger();
            if (isAPIServer) {
                initWebEngine();
            }
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
        store.init();
    }

    private void initMonitors() {
        monitorManager = new MonitorManager(connectionManager, conf);
        monitorManager.init();
    }

    private void initWebEngine() {
        webEngine = new WebEngineImpl(conf);
        webEngine.init();
    }

    private void initConnectionManager() {
        connectionManager = ConnectionManagerImpl.CMHolder.INSTANCE.connectionManager;
        connectionManager.init();
    }

    private void initRegionManger() {
        regionRoute = new RegionRouteImpl();
        regionRoute.init();
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
    public void injectResource(CloudManager cloudManager) {
        if(isAPIServer){
            regionRoute.inject(cloudManager);
        }
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

