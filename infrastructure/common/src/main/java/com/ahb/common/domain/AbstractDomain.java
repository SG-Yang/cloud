package com.ahb.common.domain;

import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
import com.ahb.common.web.ViewPayload;
import com.google.common.collect.Maps;
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
        handlers.put(HandlerType.LOING, new Handler() {
            @Override
            public ViewPayload handle(Domain domain, InternalReq req) {
                LOGGER.info("handle request:" + req);
                ViewPayload payload = domain.toView();
                return payload;
            }

            @Override
            public HandlerType getType() {
                return HandlerType.LOING;
            }
        });
    }

    private String domainName;
    private String domainId;

    public AbstractDomain(String name, String id) {
        this.domainId = id;
        this.domainName = name;
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
        ViewPayload payload = new ViewPayload();
        return payload;
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
}
