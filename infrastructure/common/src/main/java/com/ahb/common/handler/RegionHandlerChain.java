package com.ahb.common.handler;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class RegionHandlerChain extends AbstractHandler {
    public RegionHandlerChain(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context doHandle(Context context) {
        return context;
    }
}
