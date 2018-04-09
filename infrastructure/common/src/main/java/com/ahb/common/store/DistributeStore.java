package com.ahb.common.store;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainValueHolder;
import com.ahb.common.exchange.ExchangeInfo;
import com.ahb.common.exchange.ExchangeType;
import com.ahb.common.node.CloudManager;
import com.ahb.common.node.NodeImpl;
import com.ahb.common.region.Criteria;
import com.ahb.common.region.Region;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

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
        ExchangeInfo info = new ExchangeInfo();
        try {
            info.setEType(ExchangeType.BIZ_DIS);
            info.setStep(1);
            info.setToken(UUID.randomUUID().toString());
            info.setFromNode(NodeImpl.NodeHolder.INSTANCE.getNode().getNodeInfo().toNodeAxis());
            info.setBusinessObj(new Gson().toJson(criteria));
            cloudManager.exchange(info);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public DomainValueHolder get(String domainId) {
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

    @Override
    public Collection<Region<Domain>> getAll() {
        return null;
    }
}
