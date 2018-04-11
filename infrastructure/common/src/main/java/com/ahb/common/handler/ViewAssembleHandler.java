package com.ahb.common.handler;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class ViewAssembleHandler extends AbstractHandler {
    public ViewAssembleHandler(){
        this(HandlerType.ASSEMBLE_VIEW);
    }
    public ViewAssembleHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context doHandle(Context context) {
        return context;
    }
}
