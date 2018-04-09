package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.store.Store;

import java.util.Collection;

/**
 * Created by aheroboy on 19/3/2018.
 */
public interface ResourceLocator {
    void mapDomain(Domain domain);
    Collection<Store> locate(String domainId, Criteria criteria);
}
