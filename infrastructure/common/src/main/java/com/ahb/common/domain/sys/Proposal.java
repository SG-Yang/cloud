package com.ahb.common.domain.sys;

import com.ahb.common.view.View;

/**
 * Created by aheroboy on 13/4/2018.
 */
public interface Proposal {
    View getProposals(String proposal);
    void initProposals();
}
