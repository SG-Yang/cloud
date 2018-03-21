package com.ahb.common.region;

import com.ahb.common.HotInstallable;
import com.ahb.common.domain.Domain;
import com.ahb.common.node.CloudManager;

import java.util.Collection;

/**
 * Created by aheroboy on 9/3/2018.
 */
public interface Region<T> extends HotInstallable<T> {
    String getPath();
    Domain getDomain(String domainId);
    Collection<Domain> getAll();
    String getRegionName();
    void register(CloudManager cloudManager);

}
