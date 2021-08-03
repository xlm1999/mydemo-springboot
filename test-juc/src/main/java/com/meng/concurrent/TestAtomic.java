package com.meng.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    public static void main(String[] args) throws InterruptedException {
        Atomic ato = new Atomic();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            new Thread(ato).start();
        }
    }
}

class Atomic implements Runnable {

    private AtomicInteger i = new AtomicInteger(1);
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "： " + i.getAndAdd(2));
    }
}