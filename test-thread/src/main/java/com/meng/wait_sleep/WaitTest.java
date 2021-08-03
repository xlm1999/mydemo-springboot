package com.meng.wait_sleep;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread, "myThread");

        t.start();
    }
}


class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}