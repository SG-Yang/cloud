package com.ahb.common.handler;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class ViewHandler implements Handler {
    @Override
    public Context handle(Context res) {

        return res;
    }

    @Override
    public Handler add(Handler handler) {
        return null;
    }

    @Override
    public HandlerType getType() {
        return null;
    }
}
