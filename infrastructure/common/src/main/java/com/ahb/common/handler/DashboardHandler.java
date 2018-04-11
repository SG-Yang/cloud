package com.ahb.common.handler;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class DashboardHandler extends AbstractHandler {
    public DashboardHandler() {
        this(HandlerType.DASHBOARD);
    }

    public DashboardHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context doHandle(Context res) {

        return res;
    }
}
