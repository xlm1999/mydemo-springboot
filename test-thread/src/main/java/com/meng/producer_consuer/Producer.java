package com.meng.producer_consuer;

public class Producer implements Runnable {
    private Goods goods;
    public static final int MAX_POOL = 10;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TestPC.queue) {

                goods = new Goods(1, "商品");
                if (TestPC.queue.size() < MAX_POOL) {
                    TestPC.queue.add(goods);
                    System.out.println(Thread.currentThread().getName() + "生产商品");

                } else {
                    try {
                        TestPC.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
