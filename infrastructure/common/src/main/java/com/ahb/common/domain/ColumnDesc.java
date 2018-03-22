package com.ahb.common.domain;

/**
 * Created by aheroboy on 22/3/2018.
 */
public class ColumnDesc {
    private ColumnType columnType;
    private Handler handlers[];
    private int seq;

    public ColumnDesc(int seq, ColumnType columnType) {
        this.columnType = columnType;
        this.seq = seq;
    }

    public ColumnDesc(int seq, ColumnType columnType, Handler handlers[]) {
        this(seq, columnType);
        this.handlers = handlers;
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
}
