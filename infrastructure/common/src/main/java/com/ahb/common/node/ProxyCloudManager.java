package com.ahb.common.node;

import com.ahb.common.exchange.*;
import org.apache.thrift.TException;

/**
 * Created by aheroboy on 12/3/2018.
 */
public class ProxyCloudManager implements CloudManager {
    private Axis axis;
    private ExchangeService.Client client;
    private NodeInfo nodeInfo;

    public ProxyCloudManager(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
        createClientId();
    }

    public ProxyCloudManager(NodeAxis nodeAxis) {
        this.nodeInfo = new NodeInfo(nodeAxis);
        createClientId();
    }

    private void createClientId() {
        try {
            client = ClientBuilder.getBuilder()
                    .ofHost(nodeInfo.getNodeId().getIp())
                    .ofPort(nodeInfo.getNodeId().getPort())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setAxis(Axis axis) {
        this.axis = axis;
    }


    @Override
    public NodeInfo getNodeInfo() {
        return nodeInfo;
    }

    @Override
    public ExchangeInfo exchange(ExchangeInfo input) throws TException {
        try {
            return client.exchange(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JoinResp requestJoin(JoinReq req) throws TException {
        return client.requestJoin(req);
    }

    @Override
    public JoinResp doJoin(JoinReq req) throws TException {
        return client.doJoin(req);
    }

    @Override
    public void cleanToken(ExchangeInfo token) throws TException {
        client.cleanToken(token);
    }
}
