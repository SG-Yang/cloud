package com.ahb.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by aheroboy on 22/3/2018.
 */
public class AhbForkJoinPool extends ForkJoinPool {

    public AhbForkJoinPool() {
        super();
    }

    public AhbForkJoinPool(int parallelism) {
        super(parallelism);
    }

    public AhbForkJoinPool(int parallelism, ForkJoinWorkerThreadFactory factory, Thread.UncaughtExceptionHandler handler, boolean asyncMode) {
        super(parallelism, factory, handler, asyncMode);
    }

    @Override
    public <T> T invoke(ForkJoinTask<T> task) {
        return super.invoke(task);
    }

    @Override
    public void execute(ForkJoinTask<?> task) {
        super.execute(task);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(task);
    }

    @Override
    public <T> ForkJoinTask<T> submit(ForkJoinTask<T> task) {
        return super.submit(task);
    }

    @Override
    public <T> ForkJoinTask<T> submit(Callable<T> task) {
        return super.submit(task);
    }

    @Override
    public <T> ForkJoinTask<T> submit(Runnable task, T result) {
        return super.submit(task, result);
    }

    @Override
    public ForkJoinTask<?> submit(Runnable task) {
        return super.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        return super.invokeAll(tasks);
    }

    @Override
    public ForkJoinWorkerThreadFactory getFactory() {
        return super.getFactory();
    }

    @Override
    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return super.getUncaughtExceptionHandler();
    }

    @Override
    public int getParallelism() {
        return super.getParallelism();
    }

    @Override
    public int getPoolSize() {
        return super.getPoolSize();
    }

    @Override
    public boolean getAsyncMode() {
        return super.getAsyncMode();
    }

    @Override
    public int getRunningThreadCount() {
        return super.getRunningThreadCount();
    }

    @Override
    public int getActiveThreadCount() {
        return super.getActiveThreadCount();
    }

    @Override
    public boolean isQuiescent() {
        return super.isQuiescent();
    }

    @Override
    public long getStealCount() {
        return super.getStealCount();
    }

    @Override
    public long getQueuedTaskCount() {
        return super.getQueuedTaskCount();
    }

    @Override
    public int getQueuedSubmissionCount() {
        return super.getQueuedSubmissionCount();
    }

    @Override
    public boolean hasQueuedSubmissions() {
        return super.hasQueuedSubmissions();
    }

    @Override
    protected ForkJoinTask<?> pollSubmission() {
        return super.pollSubmission();
    }

    @Override
    protected int drainTasksTo(Collection<? super ForkJoinTask<?>> c) {
        return super.drainTasksTo(c);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return super.shutdownNow();
    }

    @Override
    public boolean isTerminated() {
        return super.isTerminated();
    }

    @Override
    public boolean isTerminating() {
        return super.isTerminating();
    }

    @Override
    public boolean isShutdown() {
        return super.isShutdown();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return super.awaitTermination(timeout, unit);
    }

    @Override
    public boolean awaitQuiescence(long timeout, TimeUnit unit) {
        return super.awaitQuiescence(timeout, unit);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return super.newTaskFor(runnable, value);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return super.newTaskFor(callable);
    }
}
