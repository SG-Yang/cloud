package com.ahb.common.web;

import com.ahb.common.domain.Domain;
import com.ahb.common.node.CloudManager;
import com.ahb.common.region.Region;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by aheroboy on 16/3/2018.
 * //In charge of handling any operations to this region.
 */
public class RegionHolder extends AbstractHolder {

    public RegionHolder(Region region) {
        super(region);
    }

    public void doDistribute(InternalReq req, InternalResp resp) {
        String domainId = req.getDomainId();
        if (StringUtils.isNotBlank(domainId)) {
            Domain domain = region.getDomain(domainId);
            if (domain != null) {
                domain.handle(req, resp);
            }
        }
    }

    @Override
    public void install(CloudManager installable) {
        region.register(installable);
    }
}
