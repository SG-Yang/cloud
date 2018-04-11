package com.ahb.common.domain;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class SystemAdminDef extends AbstractDomain {

    public static final String REGION_CREATOR_DOMAIN = "admin";

    public SystemAdminDef() {
        this(REGION_CREATOR_DOMAIN, REGION_CREATOR_DOMAIN);
    }

    public SystemAdminDef(String name, String id) {
        super(name, id);
    }

}
