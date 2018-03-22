package com.ahb.common.node;

import com.ahb.common.exchange.ExchangeService;
import com.google.common.collect.Sets;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.Set;

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

    public static void main(String xargs[]) throws Exception{
        Set<ExchangeService.Client> clientSet = Sets.newHashSet();
        for(int i = 1 ; i < 254;i++){
            for(int j = 1 ; j < 254;j++){
                StringBuilder ipPrefix = new StringBuilder("12.0.");
                ipPrefix.append(i).append(".").append(j);
                System.out.println(ipPrefix);
                clientSet.add(ClientBuilder.getBuilder().ofPort(8080).ofHost(ipPrefix.toString()).build());
            }
        }
    }

}
