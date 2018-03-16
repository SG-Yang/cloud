package com.ahb.common.node;

import com.ahb.common.Conf;
import com.ahb.common.LifeCycle;

/**
 * Created by aheroboy on 9/3/2018.
 */
public interface Node extends LifeCycle{
    String CENTOER_NODE_IP = "localhost";
    int CENTOER_NODE_PORT = 9090;
    Conf getConf();
    NodeInfo getNodeInfo();
    void setNodeInfo(NodeInfo nodeInfo);
}
