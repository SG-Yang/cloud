package com.ahb.common.handler;

import com.ahb.common.domain.Domain;
import com.ahb.common.region.ResourceLocator;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.ahb.common.view.View;

/**
 * Created by aheroboy on 10/4/2018.
 */
public interface Context extends View {
    boolean isDone();
    Domain getDomain();
    InternalResp getInternalResp();
    InternalReq getInternalReq();
    ResourceLocator getLocator();
}
