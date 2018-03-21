package com.ahb.common.web;

import com.ahb.common.domain.Domain;
import com.ahb.common.region.AbstractRegion;
import com.ahb.common.region.Holder;
import com.ahb.common.region.Region;

import java.util.Collection;

/**
 * Created by aheroboy on 16/3/2018.
 */
public abstract class AbstractHolder implements Distributor, Holder {
    protected Region region;
    public AbstractHolder(Region<Domain> domainRegion){
        this.region = domainRegion;
    }
    @Override
    public Region get() {
        return null;
    }

    @Override
    public void distribute(InternalReq req, InternalResp resp) {
        doDistribute(req, resp);
        resp.output();
    }

    public abstract void doDistribute(InternalReq req, InternalResp resp);
}
