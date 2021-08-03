package com.meng.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class TestIcon {
    public static void main(String[] args){
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int x = 0;x < 10; x++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{
    //private volatile int i = 0;
    AtomicInteger i = new AtomicInteger();
    public int getI(){
//        return i++;
        return i.getAndIncrement();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getI());
    }
}