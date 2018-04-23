package com.ahb.common.domain;

import com.ahb.common.handler.ViewAssembleHandler;
import com.ahb.common.region.RegionViewImpl;
import com.ahb.common.view.ProposalView;
import com.ahb.common.view.View;
import com.ahb.common.view.ViewId;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class ViewManagerImpl extends AbstractDomain implements Viewable, ViewManager {
    public static final String NAME = "view";
    private List<View> views = Lists.newArrayList();

    public ViewManagerImpl() {
        this(NAME, NAME);
        install(new ViewAssembleHandler());
    }

    public ViewManagerImpl(String name, String id) {
        super(name, id);
    }

    @Override
    public View getViewById(ViewId viewId) {
        return new RegionViewImpl();
    }

    @Override
    public List<ProposalView> getAllProposalViews() {
        return views.stream().map((View view) -> view.getProposal()).collect(Collectors.toList());
    }

    @Override
    public ViewManager addView(View view) {
        this.views.add(view);
        return this;
    }
}
