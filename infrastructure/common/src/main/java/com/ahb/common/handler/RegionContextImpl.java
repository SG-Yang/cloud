package com.ahb.common.handler;

import com.ahb.common.domain.Domain;
import com.ahb.common.region.Region;
import com.ahb.common.region.ResourceLocator;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.google.gson.JsonObject;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class RegionContextImpl implements Context {
    private InternalReq req;
    private InternalResp resp;
    private boolean sucess;
    private boolean done;
    private OpIns opIns;
    private ResourceLocator locator;
    private Region region;

    public RegionContextImpl(InternalReq req, InternalResp resp, OpIns opIns, ResourceLocator resourceLocator, Region<Domain> region) {
        this.req = req;
        this.resp = resp;
        this.opIns = opIns;
        this.locator = resourceLocator;
        this.region = region;
    }

    @Override
    public boolean isDone() {
        return !sucess || done;
    }

    @Override
    public JsonObject toViewObj() {
        return null;
    }
}
