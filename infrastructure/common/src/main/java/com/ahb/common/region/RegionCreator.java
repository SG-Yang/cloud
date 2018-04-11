package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.RegionCreatorDomain;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class RegionCreator extends AbstractRegion {
    public RegionCreator(){
        this(new RegionCreatorDomain());
    }
    public RegionCreator(Domain regionDomain) {
        super(regionDomain);
    }
}
