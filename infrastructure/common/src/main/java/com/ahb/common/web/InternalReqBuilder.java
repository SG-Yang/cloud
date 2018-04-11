package com.ahb.common.web;

import com.ahb.common.handler.CriteriaParser;
import com.ahb.common.handler.OpIns;
import com.ahb.common.handler.RegionHandlerChain;
import com.ahb.common.region.Criteria;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class InternalReqBuilder {
    private HttpServletRequest request;
    private static final String PREFIX = "/";
    private static final CriteriaParser parser = new CriteriaParser();

    public static final InternalReqBuilder newInstance() {
        return new InternalReqBuilder();
    }

    public InternalReqBuilder ofServletRequest(HttpServletRequest request) {
        this.request = request;
        return this;
    }

    public InternalReq build() {
        try {
            Gson gson = new Gson();
            OperatePayload payload = gson.fromJson(request.getReader(), OperatePayload.class);
            OpIns opIns = parser.parse(payload.getCriteria());
            if(opIns == null){
                //TODO:
            }
            InternalReq req = new InternalReq(payload,opIns);
            String contextPath = request.getPathInfo();
            if (StringUtils.startsWith(contextPath, PREFIX)) {
                String regionUrl = StringUtils.replaceFirst(contextPath, PREFIX, "");
                String[] paths = regionUrl.split(PREFIX);
                req.setRegionUrl(paths[0]);
                if (paths.length > 1) {
                    req.setDomainId(paths[1]);
                }
                if (paths.length > 2) {
                    req.setTargetUrl(paths[2]);
                }
            }
            req.setSession(new CloudSession(request.getSession()));
            return req;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
