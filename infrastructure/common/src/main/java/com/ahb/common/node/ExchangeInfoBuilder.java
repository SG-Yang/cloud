package com.ahb.common.node;

import com.ahb.common.exchange.ExchangeInfo;
import com.ahb.common.exchange.ExchangeType;
import com.ahb.common.exchange.NodeAxis;

/**
 * Created by aheroboy on 14/3/2018.
 */
public class ExchangeInfoBuilder {
    private java.lang.String token;
    private NodeAxis fromNode;
    private ExchangeType eType;
    private NodeAxis initNode;
    private int step;
    private String bizObj;

    public ExchangeInfoBuilder ofToken(String token) {
        this.token = token;
        return this;
    }

    public ExchangeInfoBuilder ofFromNode(NodeAxis fromNode) {
        this.fromNode = fromNode;
        return this;
    }

    public ExchangeInfoBuilder ofEType(ExchangeType eType) {
        this.eType = eType;
        return this;
    }

    public ExchangeInfoBuilder ofInitNode(NodeAxis initNode) {
        this.initNode = initNode;
        return this;
    }

    public ExchangeInfoBuilder ofStep(int step) {
        this.step = step;
        return this;
    }

    public ExchangeInfoBuilder ofBizObj(String obj) {
        this.bizObj = obj;
        return this;
    }

    private ExchangeInfoBuilder() {
    }

    public static ExchangeInfoBuilder newInstance() {
        return new ExchangeInfoBuilder();
    }

    public ExchangeInfo build() {
        return new ExchangeInfo(token, fromNode, eType, initNode, step, bizObj);
    }
}
