package com.ahb.common.domain;

import com.ahb.common.web.InternalReq;
import com.ahb.common.web.ViewPayload;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface Handler {
    ViewPayload handle(Domain domain, InternalReq req);
    HandlerType getType();
}
