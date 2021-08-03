package com.meng.concurrent;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCalable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask).start();
        Integer integer = futureTask.get();
        System.out.println(integer);
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        for (int i = 0; i < 100000; i++) {
            i++;
        }
        System.out.println(threadDemo.sum);

    }
}

class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}

class ThreadDemo implements Runnable {

    int sum = 0;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
    }
}