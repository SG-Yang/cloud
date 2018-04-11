package com.ahb.common.domain;

import com.ahb.common.handler.DomainHandlerChain;
import com.ahb.common.handler.DomainContextImpl;
import com.ahb.common.handler.Handler;
import com.ahb.common.handler.HandlerType;
import com.ahb.common.region.Region;
import com.ahb.common.region.ResourceLocator;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.ahb.common.web.ViewPayload;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class AbstractDomain implements Domain {
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractDomain.class);

    private String domainName;
    private String domainId;
    private DomainDesc domainDesc;
    private Map<HandlerType, DomainHandlerChain> chains = Maps.newHashMap();
    private Region region;

    public AbstractDomain(String name, String id, DomainDesc domainDesc) {
        this.domainId = id;
        this.domainName = name;
        this.domainDesc = domainDesc;
    }

    //TODO: handle output.
    @Override
    public void handle(InternalReq req, InternalResp resp, Region region, ResourceLocator locator) {
        DomainHandlerChain handler = chains.get(req.getType());
        resp.setPayload(new ViewPayload(handler.handle(new DomainContextImpl(this, req, resp))));
    }

    @Override
    public void install(Handler handler) {
        chains.get(handler.getType()).chainUp(handler);
    }

    @Override
    public long getBusinessId() {
        return 0;
    }

    @Override
    public int getLocateVersion() {
        return 0;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public String getId() {
        return domainId == null ? domainName : domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public DomainDesc getDomainDesc() {
        return domainDesc;
    }

    public void setDomainDesc(DomainDesc domainDesc) {
        this.domainDesc = domainDesc;
    }
}
