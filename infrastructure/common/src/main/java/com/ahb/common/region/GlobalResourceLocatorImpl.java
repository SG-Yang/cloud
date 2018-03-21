package com.ahb.common.region;

import com.ahb.common.HotInstallable;
import com.ahb.common.domain.Domain;
import com.ahb.common.node.CloudManager;
import com.ahb.common.node.NodeId;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 19/3/2018.
 */
public class GlobalResourceLocatorImpl implements ResourceLocator, HotInstallable<CloudManager> {

    private static final Map<NodeId, CloudManager> nodes = Maps.newHashMap();

    @Override
    public String locate(Domain domain) {
        return null;
    }

    @Override
    public void install(CloudManager installable) {
        nodes.put(installable.getNodeInfo().getNodeId(), installable);
    }

    public Map<NodeId, CloudManager> getNodes() {
        return nodes;
    }
}
