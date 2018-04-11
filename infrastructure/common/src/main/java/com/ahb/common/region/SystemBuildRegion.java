package com.ahb.common.region;

import com.ahb.common.domain.*;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class SystemBuildRegion extends AbstractRegion {
    public SystemBuildRegion() {
        this(new SystemBuildDomain());
    }

    public SystemBuildRegion(Domain regionDomain) {
        super(regionDomain);

        install(new RegionCreator());
        install(new Dashboard());
        install(new HandlerManager());
    }
}
