package com.ahb.common.store;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainValueHolder;
import com.ahb.common.region.Criteria;
import com.ahb.common.region.Region;

import java.util.Collection;

/**
 * Created by aheroboy on 8/4/2018.
 */
public class DBStore implements Store {
    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStarting() {
        return false;
    }

    @Override
    public boolean isStopping() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public void init() {

    }

    @Override
    public void save(DomainValueHolder domainValue) {

    }

    @Override
    public DomainValueHolder get(String domainId) {
        return null;
    }

    @Override
    public Collection<Region<Domain>> getAll() {
        return null;
    }

    @Override
    public Collection<DomainValueHolder> execute(Criteria criteria) {
        return null;
    }
}
