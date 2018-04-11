package com.ahb.common.domain;

import com.ahb.common.handler.DomainContextImpl;
import com.ahb.common.handler.Handler;
import com.ahb.common.handler.HandlerType;
import com.ahb.common.region.Region;
import com.ahb.common.region.ResourceLocator;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.ahb.common.view.ViewPayload;
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
    public static final DomainDesc domainDesc = new DomainDesc();
    private Map<HandlerType, Handler> chains = Maps.newHashMap();
    private Region region;
    static {
        domainDesc.add(new ColumnDesc(1,ColumnType.LONG,Domain.SEQ));
        domainDesc.add(new ColumnDesc(2,ColumnType.STRING,Domain.NAME));
        domainDesc.add(new ColumnDesc(3,ColumnType.STRING,Domain.BUSINESS_ID));
        domainDesc.add(new ColumnDesc(4,ColumnType.LONG,Domain.ID));
    }

    public AbstractDomain(String name, String id) {
        this.domainId = id;
        this.domainName = name;
    }

    @Override
    public Region<Domain> getRegion() {
        return this.region;
    }

    //TODO: handle output.
    @Override
    public void handle(InternalReq req, InternalResp resp, Region region, ResourceLocator locator) {
        Handler handler = chains.get(req.getType());
        resp.setPayload(new ViewPayload(handler.handle(new DomainContextImpl(this, req, resp))));
    }

    @Override
    public void install(Handler handler) {
        if (chains.containsKey(handler.getType())) {
            chains.get(handler.getType()).add(handler);
        } else {
            chains.put(handler.getType(), handler);
        }
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
}
