package com.ahb.common.node;

import com.ahb.common.AhbForkJoinPool;
import com.ahb.common.exchange.ExchangeInfo;
import com.ahb.common.exchange.ExchangeService;
import com.ahb.common.exchange.JoinReq;
import com.ahb.common.exchange.JoinResp;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

/**
 * Created by aheroboy on 22/3/2018.
 */
public class AhbExchangeHandler implements ExchangeService.Iface, ExchangeService.AsyncIface {
    private AhbForkJoinPool taskPool = new AhbForkJoinPool(/*change parallelism in the future.*/);
    private ConnectionManager connectionManager;

    public AhbExchangeHandler(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void exchange(ExchangeInfo input, AsyncMethodCallback<ExchangeInfo> resultHandler) throws TException {
        taskPool.execute(() -> {
            try {
                resultHandler.onComplete(exchange(input));
            } catch (Exception e) {
                resultHandler.onError(e);
            }
        });
    }

    @Override
    public ExchangeInfo exchange(ExchangeInfo input) throws TException {
        return connectionManager.exchange(input);
    }

    @Override
    public void requestJoin(JoinReq req, AsyncMethodCallback<JoinResp> resultHandler) throws TException {
        taskPool.execute(() -> {
            try {
                JoinResp resp = requestJoin(req);
                resultHandler.onComplete(resp);
            } catch (Exception e) {
                resultHandler.onError(e);
            }

        });
    }

    @Override
    public JoinResp requestJoin(JoinReq req) throws TException {
        return connectionManager.requestJoin(req);
    }


    @Override
    public void doJoin(JoinReq req, AsyncMethodCallback<JoinResp> resultHandler) throws TException {
        taskPool.execute(() -> {
            try {
                resultHandler.onComplete(doJoin(req));
            } catch (Exception e) {
                resultHandler.onError(e);
            }

        });
    }

    //TODO: receive do join event then add to resource manager.
    @Override
    public JoinResp doJoin(JoinReq req) throws TException {
        return connectionManager.doJoin(req);
    }


    @Override
    public void cleanToken(ExchangeInfo exchangeInfo, AsyncMethodCallback<Void> resultHandler) throws TException {
        taskPool.execute(() -> {
            try {
                cleanToken(exchangeInfo);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    @Override
    public void cleanToken(ExchangeInfo exchangeInfo) throws TException {
        connectionManager.cleanToken(exchangeInfo);
    }
}
