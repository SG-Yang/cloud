package com.ahb.common.domain;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Defines the persistence or cache reference state of a domain.
 * Created by aheroboy on 20/3/2018.
 */
public class DomainDesc {
    Map<String, Integer> propertyNameToIndex = Maps.newHashMap();
    Map<String, ColumnDesc> propertyNameToColumnDesc = Maps.newHashMap();
    Map<Integer, String> indexToPropertyName = Maps.newHashMap();

    public void add(ColumnDesc columnDesc) {
        propertyNameToIndex.put(columnDesc.getColumnName(), columnDesc.getSeq());
        propertyNameToColumnDesc.put(columnDesc.getColumnName(), columnDesc);
        indexToPropertyName.put(columnDesc.getSeq(), columnDesc.getColumnName());
    }

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
