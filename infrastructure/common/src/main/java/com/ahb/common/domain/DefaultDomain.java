package com.ahb.common.domain;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class DefaultDomain extends AbstractDomain {
    public static final String NAME = "user";

    public DefaultDomain() {
        super(NAME, NAME);
    }
    public DefaultDomain(String domainName,String domainId,DomainDesc domainDesc) {
        super(domainName,domainId);
    }
}
