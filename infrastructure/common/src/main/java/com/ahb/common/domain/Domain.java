package com.ahb.common.domain;

import com.ahb.common.HotInstallable;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface Domain extends HotInstallable<Handler>{
    void handle(InternalReq req, InternalResp resp);
    String getDomainId();


}
