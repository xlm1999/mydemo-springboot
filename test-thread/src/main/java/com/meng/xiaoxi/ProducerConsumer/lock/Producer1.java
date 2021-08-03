package com.meng.xiaoxi.ProducerConsumer.lock;

/**
 * 生产者
 * @author lixiaoxi
 *
 */
public class Producer1 implements Runnable{

    private Resource1 resource;

    public Producer1(Resource1 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                resource.create();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}