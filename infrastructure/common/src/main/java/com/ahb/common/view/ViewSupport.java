package com.ahb.common.view;

import java.util.List;

/**
 * Created by aheroboy on 11/4/2018.
 */
public interface ViewSupport {
    List<ViewId> getSupporedViews();
    ViewId getChooseViewId();
    void supportView(ViewId viewId);
    void choseView(ViewId viewId);
}
