package com.ahb.common.region;

import com.ahb.common.domain.*;
import com.ahb.common.node.CloudManager;
import com.ahb.common.store.StoreImpl;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.google.common.collect.Maps;

import java.util.Map;

import static com.ahb.common.web.UnReachableHolder.UNREACHABLE_DISTRIBUTOR;

/**
 * Created by aheroboy on 17/3/2018.
 * Focus on region management and path routing.
 */
public class RegionManagerImpl implements RegionManager {
    private static Map<String, Holder> HOLDER_MAPPINGS = Maps.newHashMap();
    private RegionResourceLocatorImpl globalResourceLocator;
    public static final String GLOBAL_REGION = "GLOBAL_REGION";

    public RegionManagerImpl() {
        this.globalResourceLocator = new RegionResourceLocatorImpl();
    }

    @Override
    public void distribute(InternalReq req, InternalResp resp) {
        Holder distributor = HOLDER_MAPPINGS.get(req.getRegionUrl());
        if (distributor == null) {
            distributor = UNREACHABLE_DISTRIBUTOR;
        }
        distributor.distribute(req, resp);
    }

    @Override
    public void init() {
//        Domain regionDomainDesc = HOLDER_MAPPINGS.get(GLOBAL_REGION).get().getDomain(GLOBAL_REGION);
        //Region is a special domain which maintained by admin region.
        //TODO:Init regions from store and prepare region holders.
        StoreImpl.StoreHolder.INSTANCE.store.getAll(GLOBAL_REGION)
                .stream()
                .map((DomainValueHolder domainValueHolder) -> {
                    DefaultDomain domain = new DefaultDomain(getRegionDomainDesc());
                    return new RegionDomain(domain, domainValueHolder);
                })
                .forEach((Region region) -> initRegion(region));

        processGlobalRegion();
    }

    void processGlobalRegion() {
        Holder regionHolder = HOLDER_MAPPINGS.get(GLOBAL_REGION);
    }

    void initRegion(Region region) {
        HOLDER_MAPPINGS.put(region.getPath(), new RegionHolder(region));
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
    public void inject(CloudManager cloudManager) {
        globalResourceLocator.install(cloudManager);
    }

    //For purpose of a region definition to be or from persisted.
    public DomainDesc getRegionDomainDesc() {
        DomainDesc regionDesc = new DomainDesc();
        regionDesc.getPropertyNameToIndex().put("regionPath", 0);
        regionDesc.getPropertyNameToIndex().put("regionName", 1);
        regionDesc.getPropertyNameToIndex().put("resourceLocator", 2);
        regionDesc.getPropertyNameToIndex().put("regionDomain", 3);
        regionDesc.getPropertyNameToIndex().put("domainDefinitions", 4);

        regionDesc.getIndexToPropertyName().put(0, "regionPath");
        regionDesc.getIndexToPropertyName().put(1, "regionName");
        regionDesc.getIndexToPropertyName().put(2, "resourceLocator");
        regionDesc.getIndexToPropertyName().put(3, "regionDomain");
        regionDesc.getIndexToPropertyName().put(4, "domainDefinitions");

        regionDesc.getPropertyNameToColumnDesc().put("regionPath", new ColumnDesc(0, ColumnType.STRING));
        regionDesc.getPropertyNameToColumnDesc().put("regionName", new ColumnDesc(1, ColumnType.STRING));
        regionDesc.getPropertyNameToColumnDesc().put("resourceLocator", new ColumnDesc(2, ColumnType.DOMAIN));
        regionDesc.getPropertyNameToColumnDesc().put("regionDomain", new ColumnDesc(3, ColumnType.DOMAIN));
        regionDesc.getPropertyNameToColumnDesc().put("domainDefinitions", new ColumnDesc(4, ColumnType.DOMAIN_MAP));
        return regionDesc;
    }
}
