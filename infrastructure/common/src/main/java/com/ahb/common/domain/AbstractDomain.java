package com.ahb.common.domain;

import com.ahb.common.handler.Context;
import com.ahb.common.handler.DomainContextImpl;
import com.ahb.common.handler.Handler;
import com.ahb.common.handler.HandlerType;
import com.ahb.common.region.Region;
import com.ahb.common.region.ResourceLocator;
import com.ahb.common.view.ViewId;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
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
    private List<ViewId> supportedViewIds = Lists.newArrayList();
    private ViewId choiseViewId;

    private Region region;

    static {
        domainDesc.add(new ColumnDesc(1, ColumnType.LONG, Domain.SEQ));
        domainDesc.add(new ColumnDesc(2, ColumnType.STRING, Domain.NAME));
        domainDesc.add(new ColumnDesc(3, ColumnType.STRING, Domain.BUSINESS_ID));
        domainDesc.add(new ColumnDesc(4, ColumnType.LONG, Domain.ID));
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
        if(handler == null) {
            throw new RuntimeException("Unsupported operation for :" + req.getType());
        }
        Context context = new DomainContextImpl(this, req, resp);
        handler.handle(context);
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
    public void supportView(ViewId viewId) {
        this.supportedViewIds.add(viewId);
    }

    @Override
    public void choseView(ViewId viewId) {
        this.choiseViewId = viewId;
    }

    @Override
    public List<ViewId> getSupporedViews() {
        return this.supportedViewIds;
    }

    @Override
    public ViewId getChooseViewId() {
        return this.choiseViewId;
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
