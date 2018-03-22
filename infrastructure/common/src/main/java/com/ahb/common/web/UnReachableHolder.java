package com.ahb.common.web;

import com.ahb.common.domain.DefaultDomain;
import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainDesc;
import com.ahb.common.domain.RegionDomain;
import com.ahb.common.node.CloudManager;
import com.ahb.common.region.AbstractHolder;
import com.ahb.common.region.Holder;
import com.ahb.common.region.Region;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class UnReachableHolder extends AbstractHolder {
    public static final Holder UNREACHABLE_DISTRIBUTOR = new UnReachableHolder(new RegionDomain(new DefaultDomain(new DomainDesc())));

    private UnReachableHolder(Region<Domain> domainRegion) {
        super(domainRegion);
    }

    @Override
    public void install(CloudManager installable) {

    }

    public void doDistribute(InternalReq req, InternalResp resp) {
    }
}
