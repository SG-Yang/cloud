package com.ahb.common.handler;

import com.ahb.common.domain.Domain;
import com.ahb.common.region.CriteriaType;

import java.util.Collection;

/**
 * Created by aheroboy on 10/4/2018.
 */
public interface OpIns {
    Collection<Domain> getFrom();
    CriteriaType getCriteriaType();
}
