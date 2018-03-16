package com.ahb.common.web;

import com.ahb.common.domain.HandlerType;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class InternalReq {
    private PayloadObj payload;
    private String targetUrl;
    private String regionUrl;
    private String domainId;
    private CloudSession session;
    private HandlerType type;

    public InternalReq(PayloadObj payload) {
        this.payload = payload;
        this.type = payload.getOp();
    }

    public CloudSession getSession() {
        return session;
    }

    public void setSession(CloudSession session) {
        this.session = session;
    }


    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getRegionUrl() {
        return regionUrl;
    }

    public void setRegionUrl(String regionUrl) {
        this.regionUrl = regionUrl;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public HandlerType getType() {
        return type;
    }

    public void setType(HandlerType type) {
        this.type = type;
    }
}
