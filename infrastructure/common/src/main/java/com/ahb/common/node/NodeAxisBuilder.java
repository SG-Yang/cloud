package com.ahb.common.node;

import com.ahb.common.exchange.NodeAxis;

/**
 * Created by aheroboy on 14/3/2018.
 */
public class NodeAxisBuilder {
    private int xAxis;
    private int yAxis;
    private int zAxis;
    private java.lang.String ip;
    private int port;

    private NodeAxisBuilder() {
    }

    public static NodeAxisBuilder newInstance() {
        return new NodeAxisBuilder();
    }

    public NodeAxisBuilder ofXAxis(int xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public NodeAxisBuilder ofYAxis(int yAxis) {
        this.yAxis = yAxis;
        return this;
    }

    public NodeAxisBuilder ofZAxis(int zAxis) {
        this.zAxis = zAxis;
        return this;
    }

    public NodeAxisBuilder ofIP(String ip) {
        this.ip = ip;
        return this;
    }

    public NodeAxisBuilder ofPort(int port) {
        this.port = port;
        return this;
    }

    public NodeAxis build() {
        return new NodeAxis(xAxis, yAxis, zAxis, ip, port);
    }
}
