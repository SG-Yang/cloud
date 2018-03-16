package com.ahb.common.node;

import com.ahb.common.Conf;
import com.ahb.common.ConfImpl;
import com.ahb.common.exchange.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.net.Inet4Address;
import java.util.UUID;

/**
 * Created by aheroboy on 9/3/2018.
 */
public class MainClient {
    public static void main(String xargs[]) throws Exception{
        Conf conf = new ConfImpl();
        ExchangeService.Client client = ClientBuilder.getBuilder().ofHost(Node.CENTOER_NODE_IP).ofPort(Node.CENTOER_NODE_PORT).build();
        JoinReq req = new JoinReq();
        ExchangeInfo exInfo = new ExchangeInfo();
        exInfo.setEType(ExchangeType.JOIN);
        NodeAxis axis = new NodeAxis();

        axis.setIp(Inet4Address.getLocalHost().getHostAddress());
        axis.setPort(conf.getPort());
        exInfo.setFromNode(axis);
        exInfo.setToken(UUID.randomUUID().toString());
        req.setExInfo(exInfo);
        client.requestJoin(req);
    }
}
