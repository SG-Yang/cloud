package com.ahb.common.domain;

import com.ahb.common.handler.DashboardHandler;
import com.ahb.common.handler.ViewHandler;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class Dashboard extends AbstractDomain {
    public static final String NAME = "dashboard";
    public Dashboard(){
        this(NAME,NAME);
        install(new DashboardHandler());
        install(new ViewHandler());
    }
    public Dashboard(String name, String id) {
        super(name, id);
    }
}
