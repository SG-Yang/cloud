package com.ahb.common.web;

import javax.servlet.http.HttpSession;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class CloudSession {
    private HttpSession session;

    public CloudSession(HttpSession session) {
        this.session = session;
    }
}
