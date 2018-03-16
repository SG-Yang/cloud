package com.ahb.common.node;
/**
 * Created by aheroboy on 9/3/2018.
 */
public class LocalExchange {
    com.ahb.common.exchange.ExchangeInfo exchangeInfo;
    private NodeInfo nodeInfo;
    public LocalExchange(NodeInfo nodeInfo){
        this.nodeInfo = nodeInfo;
    }
    public LocalExchange(com.ahb.common.exchange.ExchangeInfo exchangeInfo){
       this.exchangeInfo = exchangeInfo;
    }

    public com.ahb.common.exchange.ExchangeInfo getExchangeInfo() {
        return exchangeInfo;
    }

    public void setExchangeInfo(com.ahb.common.exchange.ExchangeInfo exchangeInfo) {
        this.exchangeInfo = exchangeInfo;
    }

    public NodeInfo getNodeInfo() {
        return nodeInfo;
    }

    public void setNodeInfo(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }
}
