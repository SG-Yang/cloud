package com.ahb.common.domain;

import com.ahb.common.HotInstallable;
import com.ahb.common.handler.Handler;
import com.ahb.common.region.Region;
import com.ahb.common.region.ResourceLocator;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface Domain extends HotInstallable<Handler>{
    String NAME = "NAME";
    String SEQ = "SEQ";
    String ID = "ID";
    String BUSINESS_ID = "BIZ_ID";
    void handle(InternalReq req, InternalResp resp, Region region, ResourceLocator locator);
    String getId();
    String getDomainName();
    long getBusinessId();
    int getLocateVersion();
    DomainDesc getDomainDesc();
    Region<Domain> getRegion();
}
