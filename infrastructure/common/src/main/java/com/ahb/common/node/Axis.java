package com.ahb.common.node;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by aheroboy on 9/3/2018.
 */
public class Axis {

    private Map<NodeId, CloudManager> nodes = new HashMap();
    private CloudManager self;

    public Axis(CloudManager self) {
        addSelf(self);
    }

    public void addSelf(CloudManager self) {
        this.self = self;
        NodeId selfId = self.getNodeInfo().getNodeId();

        NodeId id = selfId.copyOf();
        id.setX(id.getX() + 1);
        nodes.put(id, null);

        id = selfId.copyOf();
        id.setX(id.getX() - 1);
        nodes.put(id, null);

        id = selfId.copyOf();
        id.setY(id.getY() + 1);
        nodes.put(id, null);

        id = selfId.copyOf();
        id.setY(id.getY() - 1);
        nodes.put(id, null);

        id = selfId.copyOf();
        id.setZ(id.getZ() + 1);
        nodes.put(id, null);

        id = selfId.copyOf();
        id.setZ(id.getZ() - 1);
        nodes.put(id, null);

        this.self.setAxis(this);
    }

    public Collection<CloudManager> getNodes() {
        return nodes.values();
    }

    public void add(NodeId nodeId, CloudManager cloudManager) {
        //TODO: may have someone added the same node.
        nodes.put(nodeId, cloudManager);
    }

    public NodeInfo getAvailable() {
        NodeId candidate = null;
        for (Map.Entry<NodeId, CloudManager> entry : nodes.entrySet()) {
            if (entry.getValue() == null) {
                candidate = entry.getKey();
                break;
            }
        }

        return candidate == null ? null : new NodeInfo(candidate);
    }

    public CloudManager getSelf() {
        return self;
    }

    public void setSelf(CloudManager self) {
        this.self = self;
    }

    public synchronized List<CloudManager> getNeighbors() {
        return this.nodes.values()
                .stream()
                .filter((CloudManager cloudManager) -> cloudManager != null)
                .collect(Collectors.toList());
    }
}
