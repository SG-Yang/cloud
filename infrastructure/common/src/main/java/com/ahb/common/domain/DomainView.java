package com.ahb.common.domain;

import com.ahb.common.web.View;
import com.ahb.common.web.ViewImpl;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class DomainView extends ViewImpl {
    private View domainValueView;
    private List<Domain> domains = Lists.newArrayList();

    public DomainView(DomainValueView domainValueView){
        this.domainValueView = domainValueView;
    }
    public DomainView(Domain domain) {
        this.domains.add(domain);
    }

    public DomainView(List<Domain> domains) {
        this.domains.addAll(domains);
    }
}
