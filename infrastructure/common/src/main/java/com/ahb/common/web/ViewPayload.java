package com.ahb.common.web;

import java.io.Serializable;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class ViewPayload implements Serializable {
    View view;
    private boolean status;

    public ViewPayload(View view) {
        this.view = view;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
