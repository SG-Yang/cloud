package com.ahb.common.region;

import com.ahb.common.node.CloudManager;
import com.ahb.common.web.InternalReq;
import com.ahb.common.web.InternalResp;
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
            region.distribute(req,resp);
            /**
            Domain domain = region.getDomain(domainId);
            if (domain != null) {
                domain.handle(req, resp);
                resp.output();
            }
             **/
        }
    }

    @Override
    public void install(CloudManager installable) {
        region.register(installable);
    }
}
