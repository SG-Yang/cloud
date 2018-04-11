package com.ahb.common.handler;

import com.ahb.common.domain.Domain;
import com.ahb.common.region.ResourceLocator;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;

/**
 * Created by aheroboy on 10/4/2018.
 */
public interface Context {
    boolean isInitiator();
    boolean isDone();

    Domain getDomain();

    InternalResp getInternalResp();

    InternalReq getInternalReq();

    ResourceLocator getLocator();
}
