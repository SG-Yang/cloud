package com.ahb.common.handler;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class DomainHandlerChain extends AbstractHandler {
    public void chainUp(Handler handler) {
        handlers.add(handler);
    }

}
