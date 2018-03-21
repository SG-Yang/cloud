package com.ahb.common.node;

import com.ahb.common.web.Distributor;

/**
 * Created by aheroboy on 17/3/2018.
 */
public interface RegionManager {
    Distributor getDistributor(String regionId);
    void inject(CloudManager cloudManager);
    void init();
}
