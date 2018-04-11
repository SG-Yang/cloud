package com.ahb.common.web;

import com.ahb.common.domain.Domain;
import com.ahb.common.node.CloudManager;
import com.ahb.common.region.AbstractHolder;
import com.ahb.common.region.Region;
import com.ahb.common.region.RegionManager;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class UnReachableHolder extends AbstractHolder {
    public UnReachableHolder(Region<Domain> domainRegion, RegionManager regionManager) {
        super(domainRegion, regionManager);
    }

    @Override
    public void install(CloudManager installable) {

    }

    public void doDistribute(InternalReq req, InternalResp resp) {
    }
}
