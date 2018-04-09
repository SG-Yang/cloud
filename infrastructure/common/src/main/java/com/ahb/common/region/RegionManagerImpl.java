package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainDesc;
import com.ahb.common.node.CloudManager;
import com.ahb.common.store.StoreImpl;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

import static com.ahb.common.web.UnReachableHolder.UNREACHABLE_DISTRIBUTOR;

/**
 * Created by aheroboy on 17/3/2018.
 * Focus on region management and path routing.
 */
public class RegionManagerImpl implements RegionManager {
    private static Map<String, Holder> HOLDER_MAPPINGS = Maps.newHashMap();
    private RegionResourceLocatorImpl globalResourceLocator;
    public static final String GLOBAL_REGION = "GLOBAL_REGION";

    public RegionManagerImpl() {
        this.globalResourceLocator = new RegionResourceLocatorImpl();
    }

    @Override
    public void distribute(InternalReq req, InternalResp resp) {
        Holder region = HOLDER_MAPPINGS.get(req.getRegionUrl());
        if (region == null) {
            region = UNREACHABLE_DISTRIBUTOR;
        }
        region.distribute(req, resp);
    }

    @Override
    public void init() {
        Collection<Region<Domain>> allRegions = StoreImpl.StoreHolder.INSTANCE.store.getAll();
        for (Region<Domain> region : allRegions) {
            initRegion(region);
        }
    }

    void initRegion(Region region) {
        HOLDER_MAPPINGS.put(region.getPath(), new RegionHolder(region));
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStarting() {
        return false;
    }

    @Override
    public boolean isStopping() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public void inject(CloudManager cloudManager) {
        globalResourceLocator.install(cloudManager);
    }

    //For purpose of a region definition to be or from persisted.
    public DomainDesc getRegionDomainDesc() {
        return null;
    }
}
