package com.ahb.common.domain;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class DomainManager extends AbstractDomain {
    public static final String NAME = "domain";

    public DomainManager() {
        this(NAME, NAME);
    }

    public DomainManager(String name, String id) {
        super(name, id);
    }
}
