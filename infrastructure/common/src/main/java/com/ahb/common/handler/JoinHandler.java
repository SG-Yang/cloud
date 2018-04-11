package com.ahb.common.handler;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class JoinHandler extends AbstractHandler{
    public JoinHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context handle(Context res) {
        return res;
    }
}
