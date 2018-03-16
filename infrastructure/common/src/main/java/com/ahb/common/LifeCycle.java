package com.ahb.common;

/**
 * Created by aheroboy on 16/3/2018.
 */
public interface LifeCycle {
    void start() throws Exception;

    void stop() throws Exception;

    boolean isRunning();

    boolean isStarted();

    boolean isStarting();

    boolean isStopping();

    boolean isStopped();
}
