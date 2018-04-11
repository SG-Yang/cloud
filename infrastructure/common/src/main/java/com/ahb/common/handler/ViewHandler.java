package com.ahb.common.handler;

import com.ahb.common.domain.DomainView;
import com.ahb.common.web.ViewPayload;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class ViewHandler extends AbstractHandler {

    public ViewHandler() {
        this(HandlerType.VIEW);
    }
    public ViewHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context handle(Context res) {
        res.getInternalResp().setPayload(new ViewPayload(new DomainView(res.getDomain())));
        return res;
    }
}
