package com.ahb.common.handler;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by aheroboy on 10/4/2018.
 */
public abstract class AbstractHandler implements Handler {
    protected List<Handler> handlers = Lists.newArrayList();
    private HandlerType type;

    AbstractHandler(HandlerType handlerType) {
        this.type = handlerType;
    }

    @Override
    public Handler add(Handler handler) {
        this.handlers.add(handler);
        return this;
    }

    @Override
    public Context handle(Context context) {

        for (Handler handler : handlers) {
            context = handler.handle(context);
            if (!context.isDone()) {
                break;
            }
        }

        doHandle(context);

        if (context.isInitiator()) {
            context.getInternalResp().output();
        }

        return context;
    }


    public abstract Context doHandle(Context context);

    @Override
    public HandlerType getType() {
        return type;
    }
}
