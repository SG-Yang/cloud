package com.ahb.common.domain;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by aheroboy on 20/3/2018.
 */
public class DomainDesc {
    Map<String, Integer> propertyNameToIndex = Maps.newHashMap();
    Map<String, ColumnDesc> propertyNameToColumnDesc = Maps.newHashMap();
    Map<Integer, String> indexToPropertyName = Maps.newHashMap();

    public Map<String, Integer> getPropertyNameToIndex() {
        return propertyNameToIndex;
    }

    public void setPropertyNameToIndex(Map<String, Integer> propertyNameToIndex) {
        this.propertyNameToIndex = propertyNameToIndex;
    }

    public Map<String, ColumnDesc> getPropertyNameToColumnDesc() {
        return propertyNameToColumnDesc;
    }

    public void setPropertyNameToColumnDesc(Map<String, ColumnDesc> propertyNameToColumnDesc) {
        this.propertyNameToColumnDesc = propertyNameToColumnDesc;
    }

    public Map<Integer, String> getIndexToPropertyName() {
        return indexToPropertyName;
    }

    public void setIndexToPropertyName(Map<Integer, String> indexToPropertyName) {
        this.indexToPropertyName = indexToPropertyName;
    }
}
