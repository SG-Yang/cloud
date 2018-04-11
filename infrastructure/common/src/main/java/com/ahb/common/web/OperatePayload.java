package com.ahb.common.web;

import com.ahb.common.handler.HandlerType;
import com.ahb.common.region.CriteriaImpl;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class OperatePayload {
    @JsonProperty("operateType")
    private HandlerType operateType;
    @JsonProperty("criteria")
    private CriteriaImpl criteria = new CriteriaImpl();
    public HandlerType getOperateType() {
        return operateType;
    }

    public void setOperateType(HandlerType operateType) {
        this.operateType = operateType;
    }

    public CriteriaImpl getCriteria() {
        return criteria;
    }

    public void setCriteria(CriteriaImpl criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "OperatePayload{" +
                "operateType=" + operateType +
                ", criteria=" + criteria +
                '}';
    }
}
