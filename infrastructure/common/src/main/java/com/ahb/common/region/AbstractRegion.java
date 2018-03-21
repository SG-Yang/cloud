package com.ahb.common.region;

import com.ahb.common.domain.DefaultDomain;
import com.ahb.common.domain.Domain;
import com.ahb.common.node.CloudManager;
import com.ahb.common.node.RegionResourceLocatorImpl;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 16/3/2018.
 * Focus on management stores,domain descriptions and operation adapter etc.
 */
public abstract class AbstractRegion implements Region<Domain> {

    protected Store persistStore;
    protected Map<String, Store> distributeStores = Maps.newHashMap();
    private Domain regionDomain;
    private String regionPath;
    private String regionName;
    private RegionResourceLocatorImpl resourceLocator;

    @Override
    public String getPath() {
        return regionPath;
    }

    public AbstractRegion(Domain regionDomain) {
        this.persistStore = StoreImpl.StoreHolder.INSTANCE.store;
        this.resourceLocator = new RegionResourceLocatorImpl();
        this.regionDomain = regionDomain;
        this.regionPath = regionDomain.getDomainId();
        this.regionName = regionPath;
    }

    @Override
    public void install(Domain installable) {
        try {
            if (persistStore != null) {
                this.persistStore.save(installable);
            }

            distributeStores.get(installable.getDomainId()).save(installable);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO:
    @Override
    public Domain getDomain(String domainId) {
        return new DefaultDomain("user", "User Login Domain");
        //return persistStore.get(domainId);
    }

    @Override
    public void register(CloudManager cloudManager) {
        resourceLocator.install(cloudManager);
    }

    public String getRegionPath() {
        return regionPath;
    }

    public void setRegionPath(String regionPath) {
        this.regionPath = regionPath;
    }

    @Override
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Domain getRegionDomain() {
        return regionDomain;
    }

    public void setRegionDomain(Domain regionDomain) {
        this.regionDomain = regionDomain;
    }

    public RegionResourceLocatorImpl getResourceLocator() {
        return resourceLocator;
    }

    public void setResourceLocator(RegionResourceLocatorImpl resourceLocator) {
        this.resourceLocator = resourceLocator;
    }
}
