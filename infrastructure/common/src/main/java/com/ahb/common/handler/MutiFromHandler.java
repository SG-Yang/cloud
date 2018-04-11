package com.ahb.common.handler;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class MutiFromHandler implements Handler {
    private Handler handler;
    @Override
    public Context handle(Context res) {
        return res;
    }

    @Override
    public Handler add(Handler handler) {
        this.handler = handler;
        return this;
    }

    @Override
    public HandlerType getType() {
        return null;
    }
}
