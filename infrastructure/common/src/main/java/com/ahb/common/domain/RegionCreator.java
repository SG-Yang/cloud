package com.ahb.common.domain;

import com.ahb.common.handler.DomainHandlerChain;
import com.ahb.common.handler.HandlerType;
import com.ahb.common.handler.RegionCreateHandler;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class RegionCreator extends AbstractDomain {
    public static final String NAME = "REGION_CREATOR_DOMAIN";

    public RegionCreator() {
        this(NAME, NAME);
    }

    public RegionCreator(String name, String id) {
        super(name, id);
        DomainHandlerChain regionCreatorChain = new DomainHandlerChain(HandlerType.CREATE_REGION_CHAIN);
        regionCreatorChain.add(new RegionCreateHandler(HandlerType.CREATE_REGION));
        install(regionCreatorChain);
    }
}
