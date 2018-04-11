package com.ahb.common.view;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class TopBottonLayout extends Layout {
    View topView;
    View bottonView;

    public TopBottonLayout ofTop(View topView) {
        this.topView = topView;
        return this;
    }

    public TopBottonLayout ofBotton(View bottonView) {
        this.bottonView = bottonView;
        return this;
    }
}
