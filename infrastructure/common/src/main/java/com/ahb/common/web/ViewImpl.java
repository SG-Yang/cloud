package com.ahb.common.web;

import com.google.gson.JsonObject;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class ViewImpl implements View {
    @Override
    public JsonObject toViewObj() {
        JsonObject viewObj = new JsonObject();
        viewObj.addProperty("t", ViewType.LIST.name());
        return viewObj;
    }
}
