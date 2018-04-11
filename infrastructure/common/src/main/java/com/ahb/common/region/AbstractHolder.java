package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.web.Distributor;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;

/**
 * Created by aheroboy on 16/3/2018.
 */
public abstract class AbstractHolder implements Distributor, Holder {
    private RegionRoute regionRoute;
    protected Region region;

    public AbstractHolder(Region<Domain> domainRegion,RegionRoute regionRoute) {
        this.region = domainRegion;
        this.regionRoute = regionRoute;
    }

    @Override
    public Region get() {
        return null;
    }

    @Override
    public void distribute(InternalReq req, InternalResp resp) {
        doDistribute(req, resp);
    }

    public abstract void doDistribute(InternalReq req, InternalResp resp);
}
