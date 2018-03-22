package com.ahb.common.monitor;

import com.ahb.common.Conf;
import com.ahb.common.LifeCycle;
import com.ahb.common.node.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aheroboy on 21/3/2018.
 */
public class MonitorManager implements LifeCycle {

    public static final Logger LOGGER = LoggerFactory.getLogger(MonitorManager.class);
    private Thread monitor;
    private Thread heartBeat;
    private ConnectionManager connectionManager;
    private Conf conf;

    public MonitorManager(ConnectionManager connectionManager, Conf conf) {
        this.connectionManager = connectionManager;
        this.conf = conf;
    }

    @Override
    public void start() throws Exception {
        monitor.start();
        heartBeat.start();
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStarting() {
        return false;
    }

    @Override
    public boolean isStopping() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public void init() {
        monitor = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {

                LOGGER.info("Server stopped.....");
            }
        }, String.join(":", new String[]{conf.getIp(), conf.getPort() + ""}));

        heartBeat = new Thread(() -> {
            //TODO: send heart beat event.
            while (true) {
                try {
                    connectionManager.areNeighborsAlive();
                    Thread.sleep(5000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
