package com.ahb.common.web;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class InternalResp {
    private static final Logger LOGGER = LoggerFactory.getLogger(InternalResp.class);
    private HttpServletResponse resp;
    private ViewPayload payload;

    public InternalResp(HttpServletResponse resp) {
        this.resp = resp;
    }

    public void output() {
        try {
            String jsonPayload = new Gson().toJson(payload);
            LOGGER.info("Response is:" + jsonPayload);
            resp.getWriter().print(jsonPayload);
            resp.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
            //TODO:
        }
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
