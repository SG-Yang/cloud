package com.ahb.common.web;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.PubLoginDomain;
import com.ahb.common.region.AdminRegion;
import com.ahb.common.region.PubRegion;
import com.ahb.common.region.Region;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class CachedPathResolver implements PathResolver {
    private static Map<String, RequestDistributor> distributorMap = Maps.newConcurrentMap();
    private static final RequestDistributor UNREACHABLE_DISTRIBUTOR = new UnReachableDistributor();

    @Override
    public RequestDistributor resolve(InternalReq internalReq) {
        String regionId = internalReq.getRegionUrl();
        RequestDistributor distributor;
        try {
            distributor = distributorMap.get(regionId);
        } catch (Exception e) {
            distributor = UNREACHABLE_DISTRIBUTOR;
        }
        return distributor;
    }

    @Override
    public void init() {
        Region adminRegion = new AdminRegion();
        distributorMap.put(adminRegion.getPath(), new RegionDistributor(adminRegion));
        Region pubRegion = new PubRegion();
        //TODO: change it.
        Domain pubLoginDomain = new PubLoginDomain(PubLoginDomain.NAME, PubLoginDomain.NAME);
        pubRegion.install(pubLoginDomain);
        distributorMap.put(pubRegion.getPath(), new RegionDistributor(pubRegion));
    }
}
