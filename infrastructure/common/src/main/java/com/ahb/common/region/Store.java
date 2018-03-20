package com.ahb.common.region;

import com.ahb.common.domain.Domain;

import java.util.Collection;

/**
 * Created by aheroboy on 17/3/2018.
 */
public interface Store {
    void save(Domain domain);
    Domain get(String domainId);
    Collection<Domain> getAll();
}
