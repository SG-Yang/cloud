package com.ahb.common.web;

import com.ahb.common.domain.HandlerType;
import com.google.gson.JsonObject;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class PayloadObj {
    private HandlerType op;
    private JsonObject c;
    public HandlerType getOp() {
        return op;
    }

    public JsonObject getC() {
        return c;
    }

    public void setC(JsonObject c) {
        this.c = c;
    }

    public void setOp(HandlerType op) {
        this.op = op;
    }
}
