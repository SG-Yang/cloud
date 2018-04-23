package com.ahb.common.view;

/**
 * Created by aheroboy on 16/4/2018.
 */
public class BoardLayoutView extends ViewImpl {
    public BoardLayoutView() {
        ProposalView proposalView = getProposal();
        proposalView.setDesc("Board layout");
        proposalView.setDisplayCommand("bl");
        proposalView.setHit("Board layout.");
        Style style = new StyleImpl();
        style.setClassId("boardlayout");
        this.setStyle(style);
        proposalView.setViewId(this.getViewId());

    }
}
