package com.ahb.common.web;

import com.ahb.common.domain.Domain;
import com.ahb.common.region.Region;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class RegionDistributor implements RequestDistributor {
    private Region region;

    public RegionDistributor(Region region) {
        this.region = region;
    }

    @Override
    public InternalResp distribute(InternalReq req) {
        InternalResp resp = new InternalResp();
        String domainId = req.getDomainId();
        if (StringUtils.isNotBlank(domainId)) {
            Domain domain = region.getDomain(domainId);
            if (domain != null) {
                domain.handle(req, resp);
            }
        }
        return resp;
    }
}
