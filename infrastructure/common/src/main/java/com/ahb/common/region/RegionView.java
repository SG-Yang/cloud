package com.ahb.common.region;

import com.ahb.common.web.ViewImpl;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class RegionView extends ViewImpl {
    private List<Region> regions = Lists.newArrayList();

    public RegionView(Region region) {
        regions.add(region);
    }

    public RegionView(List<Region> regions) {
        this.regions.addAll(regions);
    }
}
