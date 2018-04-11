package com.ahb.common.domain;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class HandlerManager extends AbstractDomain {
    public static final String NAME = "HANDLER_MANAGER";

    public HandlerManager() {
        this(NAME, NAME);
    }

    public HandlerManager(String name, String id) {
        super(name, id);
    }
}
