package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 16/3/2018.
 */
public abstract class AbstractRegion implements Region<Domain> {
    private static final Map<String, Domain> domains = Maps.newHashMap();

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public void install(Domain installable) {
        domains.put(installable.getDomainId(),installable);
    }

    @Override
    public Domain getDomain(String domainId) {
        return domains.get(domainId);
    }
}
