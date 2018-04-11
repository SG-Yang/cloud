package com.ahb.common.domain;

/**
 * Created by aheroboy on 22/3/2018.
 */
public class ColumnDesc {
    private Long id;
    private ColumnType columnType;
    private String columnName;
    private int seq;

    public ColumnDesc(int seq, ColumnType columnType, String columnName) {
        this.seq = seq;
        this.columnType = columnType;
        this.columnName = columnName;
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
