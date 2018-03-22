package com.ahb.common.store;

import com.ahb.common.Conf;
import com.ahb.common.ConfImpl;
import com.ahb.common.domain.DefaultDomain;
import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainValueHolder;
import com.ahb.common.region.Criteria;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.xerial.snappy.Snappy;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by aheroboy on 17/3/2018.
 */
public class StoreImpl implements Store { public enum StoreHolder {
        INSTANCE;
        public Store store;

        StoreHolder() {
            Conf storeConf = new ConfImpl();
            store = new StoreImpl(storeConf);
        }
    }

    @Override
    public Collection<DomainValueHolder> getAll(String domainId) {
        Collection<DomainValueHolder> domainValues = Lists.newArrayList();
        DomainValueHolder pubDomain = new DomainValueHolder();
        domainValues.add(pubDomain);
        return domainValues;
    }

    private StoreImpl(Conf conf) {
    }

    public StoreImpl() {
    }

    @Override
    public Collection<DomainValueHolder> execute(Criteria criteria) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void save(DomainValueHolder domain) {
        try {
            Gson gson = new Gson();
            String strs = gson.toJson(domain);
            System.out.println(strs);
            byte[] str = strs.getBytes();
            System.out.println(str.length);
            byte[] compressed = Snappy.compress(gson.toJson(domain));
            System.out.println(compressed.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
