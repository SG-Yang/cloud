package com.ahb.common.domain.sys;

import com.ahb.common.domain.AbstractDomain;
import com.ahb.common.handler.DomainHandlerChain;
import com.ahb.common.handler.HandlerType;
import com.ahb.common.handler.RegionCreateHandler;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class RegionManager extends AbstractDomain {
    public static final String NAME = "REGION_CREATOR_DOMAIN";

    public RegionManager() {
        this(NAME, NAME);
    }

    public RegionManager(String name, String id) {
        super(name, id);
        DomainHandlerChain regionCreatorChain = new DomainHandlerChain(HandlerType.CREATE_REGION_CHAIN);
        regionCreatorChain.add(new RegionCreateHandler(HandlerType.CREATE_REGION));
        install(regionCreatorChain);
    }
}
