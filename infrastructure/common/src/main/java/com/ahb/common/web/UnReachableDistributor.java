package com.ahb.common.web;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class UnReachableDistributor implements RequestDistributor {
    @Override
    public InternalResp distribute(InternalReq req) {
        return null;
    }
}
