package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.PubLoginDomain;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 16/3/2018.
 * Focus on management stores,domain descriptions and operation adapter etc.
 */
public abstract class AbstractRegion implements Region<Domain> {

    private Store persistStore;
    private Map<String, Store> distributeStores = Maps.newHashMap();
    private String regionPath;
    private String regionName;
    private ResourceLocator resourceLocator = new ResourceLocatorImpl();

    @Override
    public String getPath() {
        return regionPath;
    }

    public AbstractRegion() {
        this.persistStore = StoreImpl.StoreHolder.INSTANCE.store;
        this.distributeStores.put("demo",new StoreImpl());
    }

    @Override
    public void install(Domain installable) {
        try {
            if (persistStore != null) {
                this.persistStore.save(installable);
            }

            String index = resourceLocator.locate(installable);
            distributeStores.get(index).save(installable);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO:
    @Override
    public Domain getDomain(String domainId) {
        return new PubLoginDomain("user","User Login Domain");
        //return persistStore.get(domainId);
    }
}
