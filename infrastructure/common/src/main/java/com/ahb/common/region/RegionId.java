package com.ahb.common.region;

import com.google.common.base.Objects;

/**
 * Created by aheroboy on 26/3/2018.
 */
public class RegionId {
    private String regionName;

    public RegionId(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionId regionId = (RegionId) o;
        return Objects.equal(regionName, regionId.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(regionName);
    }
}
