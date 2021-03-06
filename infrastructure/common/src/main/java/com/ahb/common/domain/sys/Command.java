package com.ahb.common.domain.sys;

import com.ahb.common.domain.AbstractDomain;
import com.ahb.common.handler.EditHandler;
import com.ahb.common.region.DomainViewAssembler;
import com.ahb.common.view.ProposalView;
import com.ahb.common.view.View;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 13/4/2018.
 */
public class Command extends AbstractDomain implements Proposal {
    public static final String NAME = "command";
    private Map<String, ProposalView> proposalViews = Maps.newHashMap();

    public Command() {
        this(NAME, NAME);
        install(new EditHandler());
    }

    public Command(String name, String id) {
        super(name, id);
    }

    @Override
    public View getProposals(String proposal) {
        return proposalViews.get(proposal);
    }

    @Override
    public void initProposals() {
        DomainViewAssembler.Holder.INSTANCE.of().getAllProposals().stream().forEach((ProposalView view) -> {
            proposalViews.put(view.getDisplayCommand(), view);
        });
    }
}
