package com.ahb.common.node;

import com.ahb.common.exchange.ExchangeService;

/**
 * Created by aheroboy on 9/3/2018.
 */
public interface CloudManager extends ExchangeService.Iface {
    void setAxis(Axis axis);

    NodeInfo getNodeInfo();
}
