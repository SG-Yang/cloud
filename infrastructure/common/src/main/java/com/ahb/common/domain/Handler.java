package com.ahb.common.domain;

import com.ahb.common.web.InternalReq;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface Handler {
    void handle(Domain domain, InternalReq req);
}
