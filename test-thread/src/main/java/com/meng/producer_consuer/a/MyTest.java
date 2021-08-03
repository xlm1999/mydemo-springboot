package com.meng.producer_consuer.a;

public class MyTest {
    public static void main(String[] args) {
        Person p = new Person();

        Producer producer = new Producer(p);
        Thread p1 = new Thread(producer);
        Thread p2 = new Thread(producer);

        Consumer c = new Consumer(p);
        Thread c1 = new Thread(c);

        p1.start();
//        p2.start();
        c1.start();

    }
}
