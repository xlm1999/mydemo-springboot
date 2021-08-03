package com.meng.producer_consuer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        return "hello callable";
    }

    public static void main(String[] args) throws Exception{
        CallableTest callableTest = new CallableTest();
        FutureTask futureTask = new FutureTask(callableTest);
        Thread thread = new Thread(futureTask);
        System.out.println(thread.getState());
        thread.start();
        Thread.State state = thread.getState();
        thread.sleep(10);
        System.out.println(state);
        System.out.println(thread.getState());
        Object o = null;
        try {
            o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);
        System.out.println(thread.getState());
    }
}
