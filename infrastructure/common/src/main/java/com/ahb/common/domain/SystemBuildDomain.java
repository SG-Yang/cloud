package com.ahb.common.domain;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class SystemBuildDomain extends AbstractDomain {

    public static final String REGION_CREATOR_DOMAIN = "admin";

    public SystemBuildDomain() {
        this(REGION_CREATOR_DOMAIN, REGION_CREATOR_DOMAIN);
    }

    public SystemBuildDomain(String name, String id) {
        super(name, id);
    }

}
