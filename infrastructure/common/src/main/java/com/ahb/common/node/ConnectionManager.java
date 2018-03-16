package com.ahb.common.node;

import com.ahb.common.exchange.JoinResp;

/**
 * Created by aheroboy on 9/3/2018.
 */
public interface ConnectionManager {
    void exit();

    void serve();

    void setAxis(Axis axis);

    boolean areNeighborsAlive();

    JoinResp requestJoin();

    void buildConnectionManager();
}
