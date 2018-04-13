package com.ahb.common.region;

import com.ahb.common.domain.DefaultDomain;
import com.ahb.common.domain.Domain;
import com.ahb.common.node.CloudManager;
import com.ahb.common.store.StoreImpl;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.ahb.common.web.UnReachableHolder;
import com.ahb.common.view.ViewPayload;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by aheroboy on 17/3/2018.
 * Focus on region management and path routing.
 */
public class RegionRouteImpl implements RegionRoute {
    private static Map<String, Holder> HOLDER_MAPPINGS = Maps.newHashMap();
    private UnReachableHolder unReachableHolder = new UnReachableHolder(new DefaultRegion(new DefaultDomain()), this);
    private RegionResourceLocatorImpl globalResourceLocator;

    public RegionRouteImpl() {
        this.globalResourceLocator = new RegionResourceLocatorImpl();
    }

    @Override
    public void distribute(InternalReq req, InternalResp resp) {
        if (CriteriaType.All_REGION.equals(req.getPayload().getCriteria().getType())) {
            List<Region> regions = Lists.newArrayList();
            HOLDER_MAPPINGS.values().stream().forEach((Holder hold) -> {
                regions.add(hold.get());
            });

            resp.setPayload(new ViewPayload(new RegionViewImpl(regions)));
        }

        Holder region = HOLDER_MAPPINGS.get(req.getRegionUrl());
        if (region == null) {
            region = unReachableHolder;
        }
        region.distribute(req, resp);
    }

    @Override
    public void init() {
        initDefaultRegion();
        Collection<Region<Domain>> allRegions = StoreImpl.StoreHolder.INSTANCE.store.getAll();
        for (Region<Domain> region : allRegions) {
            initRegion(region);
        }
    }

    void initDefaultRegion() {
        initRegion(new SystemAdmin());
    }

    void initRegion(Region region) {
        HOLDER_MAPPINGS.put(region.getPath(), new RegionHolder(region, this));
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
}
