package com.ahb.common.handler;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by aheroboy on 10/4/2018.
 */
public abstract class AbstractHandler implements Handler {
    protected List<Handler> handlers = Lists.newArrayList();
    private HandlerType type;

    @Override
    public Handler add(Handler handler) {
        this.handlers.add(handler);
        return this;
    }

    @Override
    public Context handle(Context res) {
        for (Handler handler : handlers) {
            res = handler.handle(res);
            if (!res.isDone()) {
                break;
            }
        }
        return res;
    }

    @Override
    public HandlerType getType() {
        return type;
    }
}
