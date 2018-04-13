package com.ahb.common.view;

import com.ahb.common.domain.Domain;
import com.google.gson.JsonObject;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class ViewImpl implements View {
    private ViewId id;
    private Domain domain;
    private Style style;
    private ProposalView proposalView = new ProposalView();

    @Override
    public ProposalView getProposal() {
        return proposalView;
    }

    @Override
    public void setViewId(ViewId id) {
        this.id = id;
    }

    @Override
    public ViewId getViewId() {
        return this.id;
    }

    @Override
    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public Style getStyle() {
        return style;
    }

    @Override
    public JsonObject toViewObj() {
        JsonObject viewObj = new JsonObject();
        viewObj.addProperty("t", ViewType.LIST.name());
        return viewObj;
    }

    @Override
    public View copy() {
        ViewImpl copyView = new ViewImpl();
        copyView.id = this.id;
        return copyView;
    }

    @Override
    public View decorate(Domain domain) {
        this.domain = domain;
        return this;
    }
}
