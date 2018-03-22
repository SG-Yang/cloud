package com.ahb.common.store;

import com.ahb.common.domain.DomainValueHolder;
import com.ahb.common.node.CloudManager;
import com.ahb.common.region.Criteria;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by aheroboy on 19/3/2018.
 */
public class DistributeStore implements Store {

    private CloudManager cloudManager;

    public DistributeStore(CloudManager cloudManager) {
        this.cloudManager = cloudManager;
    }

    @Override
    public void save(DomainValueHolder domain) {

    }

    @Override
    public Collection<DomainValueHolder> execute(Criteria criteria) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public DomainValueHolder get(String domainId) {
        return null;
    }

    @Override
    public Collection<DomainValueHolder> getAll(String domainId) {
        return null;
    }

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
}
