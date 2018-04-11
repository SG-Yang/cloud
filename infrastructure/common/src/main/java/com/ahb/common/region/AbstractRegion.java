package com.ahb.common.region;

import com.ahb.common.domain.DefaultDomain;
import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainDesc;
import com.ahb.common.handler.HandlerType;
import com.ahb.common.handler.*;
import com.ahb.common.node.CloudManager;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

/**
 * Created by aheroboy on 16/3/2018.
 * Focus on management stores,domain descriptions and operation adapter etc.
 */
public abstract class AbstractRegion implements Region<Domain> {

    protected Map<String, Domain> domainDefinitions = Maps.newHashMap();
    private static Map<HandlerType, RegionHandlerChain> handlers = Maps.newHashMap();
    private Domain regionDomain;
    private String regionPath;
    private String regionName;
    private RegionId regionId;
    private String desc;
    private RegionResourceLocatorImpl resourceLocator;
    private RegionManager regionManager;

    static {
        RegionHandlerChain createChain = new RegionHandlerChain();
        createChain.add(new CreateRegionHandler());
        handlers.put(HandlerType.CREATE_REGION,createChain);
    }

    @Override
    public String getPath() {
        return regionPath;
    }

    public AbstractRegion(Domain regionDomain) {
        this.resourceLocator = new RegionResourceLocatorImpl();
        this.regionDomain = regionDomain;
        this.regionPath = regionDomain.getId();
        this.regionName = regionPath;
        this.regionId = new RegionId(regionName);
    }

    @Override
    public void install(Domain installable) {
        domainDefinitions.put(installable.getId(), installable);
        resourceLocator.mapDomain(installable);
        //TODO: Persist domain details descriptions.
    }

    @Override
    public void distribute(InternalReq req, InternalResp resp) {
        Domain domain = domainDefinitions.get(req.getDomainId());
        domain.handle(req,resp,this,resourceLocator);
    }

    @Override
    public Collection<Domain> getAll() {
        return null;
    }

    //TODO:
    @Override
    public Domain getDomain(String domainId) {
        return new DefaultDomain(new DomainDesc());
        //return persistStore.get(domainId);
    }

    @Override
    public void setRegionManager(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    @Override
    public RegionId getId() {
        return this.regionId;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
