package com.ahb.common.region;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by aheroboy on 22/3/2018.
 */
public class CriteriaImpl implements Criteria {
    @JsonProperty("r")
    private String regionUrl;
    @JsonProperty("d")
    private String domainId;
    @JsonProperty("t")
    private CriteriaType type;
    @JsonProperty("cd")
    private String criteriaData;

    public String getRegionUrl() {
        return regionUrl;
    }

    public void setRegionUrl(String regionUrl) {
        this.regionUrl = regionUrl;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    @Override
    public CriteriaType getType() {
        return type;
    }

    public void setType(CriteriaType type) {
        this.type = type;
    }

    public String getCriteriaData() {
        return criteriaData;
    }

    public void setCriteriaData(String criteriaData) {
        this.criteriaData = criteriaData;
    }

    @Override
    public String toString() {
        return "CriteriaImpl{" +
                "regionUrl='" + regionUrl + '\'' +
                ", domainId='" + domainId + '\'' +
                ", type=" + type +
                ", criteriaData='" + criteriaData + '\'' +
                '}';
    }
}
