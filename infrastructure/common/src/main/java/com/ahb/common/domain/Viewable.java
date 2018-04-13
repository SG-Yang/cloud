package com.ahb.common.domain;

import com.ahb.common.view.View;
import com.ahb.common.view.ViewId;

/**
 * Created by aheroboy on 12/4/2018.
 */
public interface Viewable {
    public View getViewById(ViewId viewId);
}
