package com.ahb.common.node;

import com.google.common.base.Objects;

/**
 * Created by aheroboy on 12/3/2018.
 */
public class NodeId {
    private int x;
    private int y;
    private int z;
    private String ip;
    private int port;

    public NodeId(int x, int y, int z, String ip, int port) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ip = ip;
        this.port = port;
    }

    public NodeId(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public NodeId copyOf() {
        return new NodeId(x, y, z);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeId nodeId = (NodeId) o;
        return x == nodeId.x &&
                y == nodeId.y &&
                z == nodeId.z;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y, z);
    }

    @Override
    public String toString() {
        return "NodeId{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
