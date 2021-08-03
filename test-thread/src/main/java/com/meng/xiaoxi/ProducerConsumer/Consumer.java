package com.meng.xiaoxi.ProducerConsumer;

/**
 * 消费者
 * @author lixiaoxi
 *
 */
public class Consumer implements Runnable{

    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.destroy();
        }

    }
}