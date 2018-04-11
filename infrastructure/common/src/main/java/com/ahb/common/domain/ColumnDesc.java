package com.ahb.common.domain;

import com.ahb.common.handler.Handler;

/**
 * Created by aheroboy on 22/3/2018.
 */
public class ColumnDesc {
    private Long id;
    private Handler handlers[];
    private ColumnType columnType;
    private String columnName;
    private int seq;

    public ColumnDesc(int seq, ColumnType columnType, String columnName, Handler[] handlers) {
        this(seq, columnType, columnName);
        this.handlers = handlers;
    }

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

    public Handler[] getHandlers() {
        return handlers;
    }

    public void setHandlers(Handler[] handlers) {
        this.handlers = handlers;
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
