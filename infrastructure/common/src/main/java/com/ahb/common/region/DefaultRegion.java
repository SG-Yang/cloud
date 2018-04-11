package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainValueHolder;

import java.util.Collection;

/**
 * Created by aheroboy on 20/3/2018.
 */
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
