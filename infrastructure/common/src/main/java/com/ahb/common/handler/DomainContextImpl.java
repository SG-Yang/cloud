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
public class DomainContextImpl implements Context {
    private Domain domain;
    private InternalReq req;
    private InternalResp resp;
    private ResourceLocator locator;
    private int jumpStep = 0;

    public DomainContextImpl(Domain domain, InternalReq req, InternalResp resp) {
        this.domain = domain;
        this.req = req;
        this.resp = resp;
    }

    @Override
    public ResourceLocator getLocator() {
        return this.locator;
    }

    @Override
    public InternalResp getInternalResp() {
        return this.resp;
    }

    @Override
    public InternalReq getInternalReq() {
        return this.req;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Domain getDomain() {
        return domain;
    }

    @Override
    public boolean isInitiator() {
        return jumpStep == 0;
    }
}
