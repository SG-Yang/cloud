package com.ahb.common.domain;

import com.ahb.common.region.AbstractRegion;

import java.util.Collection;

/**
 * Created by aheroboy on 20/3/2018.
 */
public class RegionDomain extends AbstractRegion {

    public RegionDomain(Domain regionDomain){
        super(regionDomain);
    }
    @Override
    public Collection<Domain> getAll() {
        return null;
    }

}
