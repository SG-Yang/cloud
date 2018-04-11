package com.ahb.common.handler;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class MutiFromHandler extends AbstractHandler{
    public static final String NAME = "MULTI_FROM";
    public MutiFromHandler(){
        super(HandlerType.MULTI_FROM);
    }
    @Override
    public Context doHandle(Context context) {
        return context;
    }
}
