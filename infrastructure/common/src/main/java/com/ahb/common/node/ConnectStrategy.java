package com.ahb.common.node;

/**
 * Created by aheroboy on 10/3/2018.
 */
public interface ConnectStrategy {
    NodeInfo evaluate(LocalExchange localExchange);
}
