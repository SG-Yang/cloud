package com.ahb.common.domain;

import com.ahb.common.web.*;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class AbstractDomain implements Domain {
    private static final Map<HandlerType, Handler> handlers = Maps.newHashMap();
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractDomain.class);

    static {
        handlers.put(HandlerType.LOGIN, new Handler() {
            @Override
            public ViewPayload handle(Domain domain, InternalReq req) {
                LOGGER.info("handle request:" + req);
                ViewPayload payload = domain.toView();
                payload.setStatus(Boolean.TRUE);
                return payload;
            }

            @Override
            public HandlerType getType() {
                return HandlerType.LOGIN;
            }
        });
    }

    private String domainName;
    private String domainId;
    private View view;
    private DomainDesc domainDesc;

    public AbstractDomain(String name, String id) {
        this.domainId = id;
        this.domainName = name;
        this.view = new ViewImpl();
    }

    //TODO: handle output.
    @Override
    public void handle(InternalReq req, InternalResp resp) {
        Handler handler = handlers.get(req.getType());
        resp.setPayload(handler.handle(this, req));
    }

    @Override
    public void install(Handler handler) {
        handlers.put(handler.getType(), handler);
    }

    @Override
    public ViewPayload toView() {
        JsonObject data = new JsonObject();
        data.addProperty("simple", "Simple1");
        data.addProperty("simple", "Simple1");
        data.addProperty("simple", "Simple1");
        JsonObject viewObj = view.toViewObj();
        ViewPayload payload = new ViewPayload(viewObj, data);
        return payload;
    }

    @Override
    public String getBusinessId() {
        return null;
    }

    @Override
    public int getLocateVersion() {
        return 0;
    }

    public static Map<HandlerType, Handler> getHandlers() {
        return handlers;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Override
    public String getDomainId() {
        return domainId == null ? domainName : domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public DomainDesc getDomainDesc() {
        return domainDesc;
    }

    public void setDomainDesc(DomainDesc domainDesc) {
        this.domainDesc = domainDesc;
    }
}
