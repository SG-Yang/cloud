package com.ahb.common.region;

import com.ahb.common.web.Distributor;

import java.util.Collection;

/**
 * Created by aheroboy on 17/3/2018.
 */
public interface Holder extends Distributor {
    Region get(String regionId);
    Collection<Region> getAll();
}
