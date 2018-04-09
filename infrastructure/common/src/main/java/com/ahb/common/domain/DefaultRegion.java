package com.ahb.common.domain;

import com.ahb.common.region.AbstractRegion;
import com.ahb.common.region.RegionDomainAnnotation;

import java.util.Collection;
import java.util.Properties;

/**
 * Created by aheroboy on 20/3/2018.
 */
@RegionDomainAnnotation
public class DefaultRegion extends AbstractRegion {

    public DefaultRegion(Domain regionDomain) {
        super(regionDomain);
    }

    public DefaultRegion(Domain regionDomain, DomainValueHolder valueHolder) {
        super(regionDomain);
        //TODO: init region from saved region domain.
    }

    @Override
    public Collection<Domain> getAll() {
        return null;
    }

}
