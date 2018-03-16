package com.ahb.common.web;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface RequestDistributor {
    InternalResp distribute(InternalReq req);
}
