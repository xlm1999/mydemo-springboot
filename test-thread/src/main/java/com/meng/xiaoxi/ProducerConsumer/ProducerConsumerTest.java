package com.meng.xiaoxi.ProducerConsumer;

public class ProducerConsumerTest {

    public static void main(String args[]) {
        Resource resource = new Resource();
        new Thread(new Producer(resource),"生产者线程1").start();//生产者线程
        new Thread(new Producer(resource),"生产者线程2").start();//生产者线程
        new Thread(new Consumer(resource),"消费者线程1").start();//消费者线程
        new Thread(new Consumer(resource),"消费者线程2").start();//消费者线程

    }
}