package com.ahb.common.node;

import com.ahb.common.domain.DefaultDomain;
import com.ahb.common.domain.Domain;
import com.ahb.common.domain.RegionDomain;
import com.ahb.common.region.Holder;
import com.ahb.common.region.Region;
import com.ahb.common.region.StoreImpl;
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
    private static final Distributor UNREACHABLE_DISTRIBUTOR = new UnReachableHolder(new RegionDomain(new DefaultDomain()));
    private RegionResourceLocatorImpl globalResourceLocator;
    public static final String GLOBAL_REGION = "GLOBAL_REGION";

    public RegionManagerImpl() {
        this.globalResourceLocator = new RegionResourceLocatorImpl();
    }

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

        //Region is a special domain which maintained by admin region.
        //TODO:Init regions from store and prepare region holders.
        StoreImpl.StoreHolder.INSTANCE.store.getAll()
                .stream()
                .map((Domain domain) -> new RegionDomain(domain))
                .forEach((Region region) -> initRegion(region));

        processGlobalRegion();
    }

    void processGlobalRegion() {
        Holder regionHolder = HOLDER_MAPPINGS.get(GLOBAL_REGION);
    }

    void initRegion(Region region) {
        HOLDER_MAPPINGS.put(region.getPath(), new RegionHolder(region));
    }

    @Override
    public void inject(CloudManager cloudManager) {
        globalResourceLocator.install(cloudManager);
    }
}
