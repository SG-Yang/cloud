package com.ahb.common.web;

import com.ahb.common.domain.Domain;
import com.ahb.common.region.Region;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * Created by aheroboy on 16/3/2018.
 * //In charge of handling any operations to this region.
 */
public class RegionHolder extends AbstractHolder {
    private Region region;

    public RegionHolder(Region region) {
        this.region = region;
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
    public Region get(String regionId) {
        return null;
    }

    @Override
    public Collection<Region> getAll() {
        return null;
    }
}
