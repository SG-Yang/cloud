package com.ahb.common.handler;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class ViewHandler extends AbstractHandler {

    public ViewHandler() {
        this(HandlerType.VIEW);
    }

    public ViewHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context doHandle(Context res) {
        return res;
    }
}
