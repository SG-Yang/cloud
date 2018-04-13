package com.ahb.common.store;

import com.ahb.common.LifeCycle;
import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainValues;
import com.ahb.common.region.Criteria;
import com.ahb.common.region.Region;

import java.util.Collection;

/**
 * Created by aheroboy on 17/3/2018.
 */
public interface Store extends LifeCycle{
    void save(DomainValues domainValue);
    DomainValues get(String domainId);
    Collection<Region<Domain>> getAll();
    Collection<DomainValues> execute(Criteria criteria);
}
