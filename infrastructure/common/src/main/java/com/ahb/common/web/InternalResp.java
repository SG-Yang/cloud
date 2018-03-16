package com.ahb.common.web;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class InternalResp {
    private HttpServletResponse resp;
    private ViewPayload payload;

    public InternalResp(HttpServletResponse resp) {
        this.resp = resp;
    }

    public void output(){
    }

    public HttpServletResponse getResp() {
        return resp;
    }

    public void setResp(HttpServletResponse resp) {
        this.resp = resp;
    }

    public ViewPayload getPayload() {
        return payload;
    }

    public void setPayload(ViewPayload payload) {
        this.payload = payload;
    }
}
