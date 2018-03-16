package com.ahb.common.region;

import com.ahb.common.domain.Domain;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class AdminRegion extends AbstractRegion{
    private static final String ADMIN_PATH = "admin";

    @Override
    public String getPath() {
        return ADMIN_PATH;
    }

    @Override
    public Domain getDomain(String domainId) {
        return null;
    }
}
