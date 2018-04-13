package com.ahb.common.domain;

import com.ahb.common.view.ViewId;
import com.ahb.common.view.ViewSupport;

import java.util.List;

/**
 * Created by aheroboy on 22/3/2018.
 */
public class DomainValues implements ViewSupport {
    private Object[] v;

    public Object[] getV() {
        return v;
    }

    public void setV(Object[] v) {
        this.v = v;
    }

    @Override
    public List<ViewId> getSupporedViews() {
        return null;
    }

    @Override
    public ViewId getChooseViewId() {
        return null;
    }

    @Override
    public void supportView(ViewId viewId) {

    }

    @Override
    public void choseView(ViewId viewId) {

    }
}
