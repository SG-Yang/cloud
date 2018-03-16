package com.ahb.common.node;

import com.ahb.common.exchange.ExchangeService;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by aheroboy on 10/3/2018.
 */
public class ClientBuilder {
    private String host;
    private int port;

    public ClientBuilder ofHost(String host) {
        this.host = host;
        return this;
    }

    public ClientBuilder ofPort(int port) {
        this.port = port;
        return this;
    }

    public ExchangeService.Client build() throws Exception {
        TTransport tTransport = new TFramedTransport(new TSocket(host, port));
        tTransport.open();
        TProtocol tProtocol = new TBinaryProtocol(tTransport);
        ExchangeService.Client client = new ExchangeService.Client(tProtocol);
        return client;
    }

    public ExchangeService.AsyncClient buildAsync() throws Exception {
        return new ExchangeService.AsyncClient(new TBinaryProtocol.Factory(), new TAsyncClientManager(), new TNonblockingSocket(host, port));
    }

    public static final ClientBuilder getBuilder() {
        return new ClientBuilder();
    }

    private ClientBuilder() {
    }

}
