package com.ahb.common.web;

import com.ahb.common.domain.Domain;
import com.ahb.common.node.CloudManager;
import com.ahb.common.region.AbstractHolder;
import com.ahb.common.region.Region;
import com.ahb.common.region.RegionRoute;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class UnReachableHolder extends AbstractHolder {
    public UnReachableHolder(Region<Domain> domainRegion, RegionRoute regionRoute) {
        super(domainRegion, regionRoute);
    }

    @Override
    public void install(CloudManager installable) {

    }

    public void doDistribute(InternalReq req, InternalResp resp) {
    }
}
