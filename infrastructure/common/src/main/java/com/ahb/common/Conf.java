package com.ahb.common;

import com.ahb.common.node.Node;

/**
 * Created by aheroboy on 9/3/2018.
 */
public interface Conf {
    int webPort = 8080;
    String getIp();
    int getPort();
    void setIp(String ip);
    void setPort(int port);
    void setNode(Node node);
    Node getNode();
    boolean isCenterNode();
    boolean getServerType();
}
