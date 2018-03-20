package com.ahb.common.web;

import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class ViewPayload implements Serializable {
    JsonObject view;
    JsonObject data;
    private boolean status;

    public ViewPayload(JsonObject view, JsonObject data) {
        this.view = view;
        this.data = data;
    }

    public JsonObject getView() {
        return view;
    }

    public void setView(JsonObject view) {
        this.view = view;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
