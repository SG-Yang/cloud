package com.ahb.common.domain;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class DefaultDomain extends AbstractDomain {
    public static final String NAME = "user";

    public DefaultDomain(DomainDesc domainDesc) {
        super(NAME, NAME, domainDesc);
    }
}
