package com.ahb.common.node;

import com.ahb.common.exchange.NodeAxis;

/**
 * Created by aheroboy on 9/3/2018.
 */
public class NodeInfo {
    private NodeId nodeId;

    public NodeInfo() {
    }

    public NodeInfo(NodeId nodeId) {
        this.nodeId = nodeId;
    }

    public NodeInfo(NodeAxis axis) {
        this.nodeId = toNodeId(axis);
    }

    public NodeId getNodeId() {
        return nodeId;
    }

    public static NodeId toNodeId(NodeAxis axis) {
        return new NodeId(axis.getXAxis(), axis.getYAxis(), axis.getZAxis(), axis.getIp(), axis.getPort());
    }

    public NodeAxis toNodeAxis() {
        return NodeAxisBuilder.newInstance()
                .ofXAxis(getNodeId().getX())
                .ofYAxis(getNodeId().getY())
                .ofZAxis(getNodeId().getZ())
                .ofIP(getNodeId().getIp())
                .ofPort(getNodeId().getPort())
                .build();
    }

    public void setNodeId(NodeId nodeId) {
        this.nodeId = nodeId;
    }
}
