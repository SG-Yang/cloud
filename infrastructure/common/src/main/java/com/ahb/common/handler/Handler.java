package com.ahb.common.handler;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface Handler {
    Context handle(Context res);

    Handler add(Handler handler);

    HandlerType getType();
}
