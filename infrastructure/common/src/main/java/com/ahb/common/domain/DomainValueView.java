package com.ahb.common.domain;

import com.ahb.common.view.ViewImpl;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class DomainValueView extends ViewImpl {
    List<DomainValueHolder> domainValueHolders = Lists.newArrayList();

    public DomainValueView(DomainValueHolder domainValueHolder) {
        this.domainValueHolders.add(domainValueHolder);
    }

    public DomainValueView(List<DomainValueHolder> values) {
        this.domainValueHolders.addAll(values);
    }

}
