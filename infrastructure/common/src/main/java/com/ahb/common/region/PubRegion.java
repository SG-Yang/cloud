package com.ahb.common.region;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class PubRegion extends AbstractRegion {
    protected static final String PUB_URL = "pub";

    @Override
    public String getPath() {
        return PUB_URL;
    }
}
