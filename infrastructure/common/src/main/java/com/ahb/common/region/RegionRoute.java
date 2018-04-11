package com.ahb.common.region;

import com.ahb.common.LifeCycle;
import com.ahb.common.node.CloudManager;
import com.ahb.common.web.Distributor;

/**
 * Created by aheroboy on 17/3/2018.
 */
public interface RegionRoute extends LifeCycle,Distributor{
    void inject(CloudManager cloudManager);
    void init();
}
