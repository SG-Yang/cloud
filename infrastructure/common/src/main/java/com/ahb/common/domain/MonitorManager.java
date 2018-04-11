package com.ahb.common.domain;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class MonitorManager extends AbstractDomain {

    public static final String NAME = "monitor";

    public MonitorManager() {
        this(NAME, NAME);
    }

    public MonitorManager(String name, String id) {
        super(name, id);
    }
}
