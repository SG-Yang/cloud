package com.ahb.common.handler;

import com.ahb.common.region.RegionRoute;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class RegionCreateHandler extends AbstractHandler{
    public RegionCreateHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context handle(Context res) {
        RegionRoute regionRoute = res.getDomain().getRegion().getRegionRoute();
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
