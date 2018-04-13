package com.ahb.common.region;

import com.ahb.common.view.Style;
import com.ahb.common.view.StyleImpl;
import com.ahb.common.view.View;
import com.ahb.common.view.ViewImpl;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class RegionViewImpl extends ViewImpl implements RegionView{
    private List<Region> regions = Lists.newArrayList();

    public RegionViewImpl(){
        Style style = new StyleImpl();
        style.setClassId("w3-container");
        this.setStyle(style);
    }

    @Override
    public View copy() {
        View regionView = new RegionViewImpl();
        regionView.setViewId(this.getViewId());
        regionView.setStyle(this.getStyle());
        return regionView;

    }

    public RegionViewImpl(Region region) {
        regions.add(region);
    }

    public RegionViewImpl(List<Region> regions) {
        this.regions.addAll(regions);
    }
}
