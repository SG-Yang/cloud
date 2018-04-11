package com.ahb.common.web;

import com.ahb.common.handler.HandlerType;
import com.ahb.common.handler.OpIns;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class InternalReq {
    private OperatePayload payload = new OperatePayload();
    private String targetUrl;
    private CloudSession session;
    private HandlerType type;
    private OpIns opIns;

    public InternalReq(OperatePayload payload,OpIns opIns) {
        this.payload = payload;
        this.type = payload.getOperateType();
        this.opIns = opIns;
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
        return this.payload.getCriteria().getRegionUrl();
    }

    public void setRegionUrl(String regionUrl) {
        this.payload.getCriteria().setRegionUrl(regionUrl);
    }

    public String getDomainId() {
        return this.payload.getCriteria().getDomainId();
    }

    public void setDomainId(String domainId) {
        this.payload.getCriteria().setDomainId(domainId);
    }

    public HandlerType getType() {
        return type;
    }

    public void setType(HandlerType type) {
        this.type = type;
    }

    public OperatePayload getPayload() {
        return payload;
    }

    public void setPayload(OperatePayload payload) {
        this.payload = payload;
    }

    public OpIns getOpIns() {
        return opIns;
    }

    public void setOpIns(OpIns opIns) {
        this.opIns = opIns;
    }

    @Override
    public String toString() {
        return "InternalReq{" +
                "payload=" + payload +
                ", targetUrl='" + targetUrl + '\'' +
                ", session=" + session +
                ", type=" + type +
                '}';
    }
}
