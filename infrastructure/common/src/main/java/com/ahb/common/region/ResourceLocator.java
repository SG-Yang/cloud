package com.ahb.common.region;

import com.ahb.common.store.Store;

import java.util.Collection;

/**
 * Created by aheroboy on 19/3/2018.
 */
public interface ResourceLocator {
    Collection<Store> locate(String domainId, Criteria criteria);
}
