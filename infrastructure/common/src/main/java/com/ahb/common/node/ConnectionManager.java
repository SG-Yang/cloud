package com.ahb.common.node;

import com.ahb.common.LifeCycle;
import com.ahb.common.exchange.ExchangeService;
import com.ahb.common.exchange.JoinResp;

/**
 * Created by aheroboy on 9/3/2018.
 */
public interface ConnectionManager extends LifeCycle,ExchangeService.Iface {
    void exit();

    void serve();

    void setAxis(Axis axis);

    boolean areNeighborsAlive();

    JoinResp requestJoin();
}
