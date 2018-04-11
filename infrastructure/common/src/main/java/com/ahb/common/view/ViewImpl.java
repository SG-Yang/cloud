package com.ahb.common.view;

import com.google.gson.JsonObject;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class ViewImpl implements View {
    private ViewId id;

    @Override
    public ViewId getViewId() {
        return this.id;
    }

    @Override
    public JsonObject toViewObj() {
        JsonObject viewObj = new JsonObject();
        viewObj.addProperty("t", ViewType.LIST.name());
        return viewObj;
    }
}
