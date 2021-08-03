package com.meng.xiaoxi.callable;

import org.junit.Test;

import java.util.concurrent.*;

public class MyTest {

    /**
     * 使用普通的Thread
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        Object o = futureTask.get();
        System.out.println(o);

        new Thread(futureTask).start();
        o = futureTask.get();
        System.out.println(o);
    }

    /**
     * 使用线程池
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCallable());
        String s = submit.get();
        executorService.shutdown();
        System.out.println(s);
    }
}
