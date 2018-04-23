package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.ViewManager;
import com.ahb.common.domain.ViewManagerImpl;
import com.ahb.common.view.ProposalView;
import com.ahb.common.view.View;
import com.ahb.common.view.ViewId;

import java.util.List;

/**
 * Created by aheroboy on 12/4/2018.
 */
public class DomainViewAssembler {
    public enum Holder {
        INSTANCE;
        private DomainViewAssembler delegator;

        Holder() {
            this.delegator = new DomainViewAssembler();
        }

        public DomainViewAssembler of() {
            return delegator;
        }
    }

    private ViewManager viewManager;

    void install(ViewManagerImpl viewManager) {
        this.viewManager = viewManager;
    }

    private DomainViewAssembler() {
    }

    public List<ProposalView> getAllProposals() {
        return viewManager.getAllProposalViews();
    }

    public View assemble(Domain domain) {
        ViewId chooseViewId = domain.getChooseViewId();
        View view = viewManager.getViewById(chooseViewId);
        if (view != null) {
            view = view.copy().decorate(domain);
        } else {
            throw new RuntimeException("Unable to find a suitable view.");
        }
        return view;
    }
}
