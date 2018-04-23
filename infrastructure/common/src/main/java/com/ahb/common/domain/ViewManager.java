package com.ahb.common.domain;

import com.ahb.common.view.ProposalView;
import com.ahb.common.view.View;
import com.ahb.common.view.ViewId;

import java.util.List;

/**
 * Created by aheroboy on 13/4/2018.
 */
public interface ViewManager {
    List<ProposalView> getAllProposalViews();
    View getViewById(ViewId viewId);
    ViewManager addView(View view);
}
