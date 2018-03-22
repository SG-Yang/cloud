package com.ahb.common.region;

import com.ahb.common.HotInstallable;
import com.ahb.common.node.CloudManager;
import com.ahb.common.node.NodeId;
import com.ahb.common.store.DistributeStore;
import com.ahb.common.store.Store;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

/**
 * Created by aheroboy on 21/3/2018.
 */
public class RegionResourceLocatorImpl implements ResourceLocator, HotInstallable<CloudManager> {
    private static final Map<NodeId, Store> nodes = Maps.newHashMap();
    private Map<String, AVLTree<AVLTree.Location>> domainLocatorTree = Maps.newTreeMap();

    @Override
    public void install(CloudManager installable) {
        nodes.put(installable.getNodeInfo().getNodeId(), new DistributeStore(installable));
    }

    @Override
    public Collection<Store> locate(String domainId, Criteria criteria) {
        Collection<Store> stores = Lists.newArrayList();
        AVLTree<AVLTree.Location> tree = domainLocatorTree.get(domainId);
        switch (criteria.getType()) {
            case ID:

                break;
            case ALL:
                tree.all().stream().forEach((AVLTree.Location location) -> {
                    stores.add(location.getStore());
                });

                break;
            default:
                //TODO: For others.
        }
        return stores;
    }

}
