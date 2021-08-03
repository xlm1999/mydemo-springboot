package com.meng.xiaoxi.ProducerConsumer.lock;

public class Consumer1 implements Runnable{

    private Resource1 resource;

    public Consumer1(Resource1 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                resource.destroy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}