package com.ahb.common.node;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.PubLoginDomain;
import com.ahb.common.region.*;
import com.ahb.common.web.Distributor;
import com.ahb.common.web.RegionHolder;
import com.ahb.common.web.UnReachableHolder;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 17/3/2018.
 * Focus on region management and path routing.
 */
public class RegionManagerImpl implements RegionManager {
    private static Map<String, Holder> HOLDER_MAPPINGS = Maps.newHashMap();
    private static final Distributor UNREACHABLE_DISTRIBUTOR = new UnReachableHolder();
    private ResourceLocator globalResourceLocator;

    @Override
    public Distributor getDistributor(String regionId) {
        Distributor distributor = HOLDER_MAPPINGS.get(regionId);
        if (distributor == null) {
            distributor = UNREACHABLE_DISTRIBUTOR;
        }
        return distributor;
    }

    @Override
    public void init() {
        Region adminRegion = new AdminRegion();
        HOLDER_MAPPINGS.put(adminRegion.getPath(), new RegionHolder(adminRegion));
        Region pubRegion = new PubRegion();
        //TODO: change it.
        Domain pubLoginDomain = new PubLoginDomain(PubLoginDomain.NAME, PubLoginDomain.NAME);
        pubRegion.install(pubLoginDomain);
        HOLDER_MAPPINGS.put(pubRegion.getPath(), new RegionHolder(pubRegion));

        //TODO:Init regions from store and prepare region holders.
        StoreImpl.StoreHolder.INSTANCE.store.getAll().stream().map((Domain domain) -> {
            Region region = new PubRegion();
            return region;
        }).forEach((Region region) -> {
            HOLDER_MAPPINGS.put(region.getPath(), new RegionHolder(region));
        });


    }

    public ResourceLocator getGlobalResourceLocator() {
        return globalResourceLocator;
    }

    public void setGlobalResourceLocator(ResourceLocator globalResourceLocator) {
        this.globalResourceLocator = globalResourceLocator;
    }
}
