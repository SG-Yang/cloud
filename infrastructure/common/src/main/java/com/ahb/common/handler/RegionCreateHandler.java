package com.ahb.common.handler;

import com.ahb.common.region.RegionManager;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class RegionCreateHandler extends AbstractHandler{
    public RegionCreateHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context handle(Context res) {
        RegionManager regionManager = res.getDomain().getRegion().getRegionManager();
        res.getInternalReq().getPayload().getCriteria().getCriteriaData();

        return null;
    }

    @Override
    public Handler add(Handler handler) {
        return null;
    }

    @Override
    public HandlerType getType() {
        return null;
    }
}
