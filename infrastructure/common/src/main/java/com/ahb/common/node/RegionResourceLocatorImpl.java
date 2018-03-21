package com.ahb.common.node;

import com.ahb.common.HotInstallable;
import com.ahb.common.domain.Domain;
import com.ahb.common.region.ResourceLocator;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 21/3/2018.
 */
public class RegionResourceLocatorImpl implements ResourceLocator, HotInstallable<CloudManager> {
    private static final Map<NodeId, CloudManager> nodes = Maps.newHashMap();

    @Override
    public void install(CloudManager installable) {
        nodes.put(installable.getNodeInfo().getNodeId(), installable);
    }

    @Override
    public String locate(Domain domain) {
        return null;
    }
}
