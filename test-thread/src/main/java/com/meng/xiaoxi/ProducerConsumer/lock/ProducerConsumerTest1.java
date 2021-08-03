package com.meng.xiaoxi.ProducerConsumer.lock;

public class ProducerConsumerTest1 {

    public static void main(String args[]) {
        Resource1 resource = new Resource1();
        new Thread(new Producer1(resource)).start();//生产者线程
        new Thread(new Producer1(resource)).start();//生产者线程
        new Thread(new Consumer1(resource)).start();//消费者线程
        new Thread(new Consumer1(resource)).start();//消费者线程

    }
}