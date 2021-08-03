package com.meng.concurrent.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.inc();
                System.out.println(Thread.currentThread().getName() + "-->>" + counter.i);
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.inc();
                System.out.println(Thread.currentThread().getName() + "-->>" + counter.i);
            }
        },"b").start();
        Thread.sleep(1000);

    }
}

class Counter {
    int i = 0;
    private Lock lock = new ReentrantLock();

    public int inc() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        i = ++i;
        lock.unlock();
        return i;
    }
}
