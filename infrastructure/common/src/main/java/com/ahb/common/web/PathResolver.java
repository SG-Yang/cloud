package com.ahb.common.web;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface PathResolver {
    RequestDistributor resolve(InternalReq internalReq);
    void init();
}
