package com.ahb.common.domain;

import com.ahb.common.handler.ViewAssembleHandler;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class ViewManager extends AbstractDomain {
    public static final String NAME = "view";

    public ViewManager() {
        this(NAME, NAME);
        install(new ViewAssembleHandler());
    }

    public ViewManager(String name, String id) {
        super(name, id);
    }
}
