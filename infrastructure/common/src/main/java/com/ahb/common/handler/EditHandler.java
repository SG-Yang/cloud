package com.ahb.common.handler;

import com.ahb.common.domain.sys.Proposal;
import com.ahb.common.region.Criteria;
import com.ahb.common.view.View;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by aheroboy on 12/4/2018.
 */
public class EditHandler extends AbstractHandler {
    public EditHandler() {
        this(HandlerType.EDIT);
    }

    public EditHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context doHandle(Context context) {
        try {
            Criteria criteria = context.getInternalReq().getPayload().getCriteria();
            switch (criteria.getType()) {
                case PROPOSAL:
                    proposal(criteria.getCriteriaData(), context);
                    break;
                default:

            }

        } catch (Exception e) {
            //TODO:
        }

        return context;
    }

    void proposal(String assembleCommand, Context context) {
        String[] commends = StringUtils.split("\\.");
        String command = commends[commends.length - 1];
        View proposals = ((Proposal) context.getDomain()).getProposals(command);
        context.setView(proposals);
    }

}
