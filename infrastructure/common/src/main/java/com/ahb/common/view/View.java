package com.ahb.common.view;

import com.ahb.common.domain.Domain;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface View extends Serializable, Component{
    void setStyle(Style style);
    Style getStyle();
    void setViewId(ViewId id);
    JsonObject toViewObj();
    ViewId getViewId();
    View copy();
    View decorate(Domain domain);
    ProposalView getProposal();
}
