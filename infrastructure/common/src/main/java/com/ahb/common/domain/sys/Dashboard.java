package com.ahb.common.domain.sys;

import com.ahb.common.domain.AbstractDomain;
import com.ahb.common.handler.DashboardHandler;
import com.ahb.common.handler.EditHandler;
import com.ahb.common.handler.ViewHandler;
import com.ahb.common.view.ViewId;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class Dashboard extends AbstractDomain {
    public static final String NAME = "dashboard";
    public Dashboard(){
        this(NAME,NAME);
        this.choseView(new ViewId("DASHBOARD"));
        install(new DashboardHandler());
        install(new ViewHandler());
    }
    public Dashboard(String name, String id) {
        super(name, id);
    }
}
