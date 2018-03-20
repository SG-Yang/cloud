package com.ahb.common.region;

import com.ahb.common.domain.Domain;

/**
 * Created by aheroboy on 19/3/2018.
 */
public interface ResourceLocator {
    String locate(Domain domain);
}
