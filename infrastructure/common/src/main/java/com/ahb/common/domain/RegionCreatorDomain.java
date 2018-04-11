package com.ahb.common.domain;

import com.ahb.common.handler.Handler;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class RegionCreatorDomain extends AbstractDomain {

    public static final String REGION_CREATOR_DOMAIN = "REGION_CREATOR_DOMAIN";
    public static final DomainDesc domainDesc = new DomainDesc();

    static {
        domainDesc.add(new ColumnDesc(1, ColumnType.STRING, Domain.NAME, new Handler[]{}));
        domainDesc.add(new ColumnDesc(2, ColumnType.STRING, Domain.BUSINESS_ID, new Handler[]{}));
        domainDesc.add(new ColumnDesc(3, ColumnType.STRING, Domain.ID, new Handler[]{}));
        domainDesc.add(new ColumnDesc(4, ColumnType.LONG, Domain.SEQ, new Handler[]{}));
    }

    public RegionCreatorDomain() {
        this(REGION_CREATOR_DOMAIN, REGION_CREATOR_DOMAIN, domainDesc);
    }

    public RegionCreatorDomain(String name, String id, DomainDesc domainDesc) {
        super(name, id, domainDesc);
    }

}
