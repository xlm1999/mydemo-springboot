package com.meng.ticket;

public class TicketSell extends Thread {

    public static void main(String[] args) {
        //创建 3 个窗口
        TicketSell t1 = new TicketSell("A窗口");
        TicketSell t2 = new TicketSell("B窗口");
        TicketSell t3 = new TicketSell("C窗口");

        //启动 3 个窗口进行买票
        t1.start();
        t2.start();
        t3.start();
    }

    //定义一共有 50 张票，注意声明为 static,表示几个窗口共享
    private static int num = 50;

    //调用父类构造方法，给线程命名
    public TicketSell(String string) {
        super(string);
    }

    @Override
    public void run() {
        //票分 50 次卖完
        for (int i = 0; i < 50; i++) {
            synchronized (this.getClass()) {
                if (num > 0) {
                    try {
                        sleep(0); //模拟卖票需要一定的时间
                    } catch (InterruptedException e) {
                        // 由于父类的 run()方法没有抛出任何异常，根据继承的原则，子类抛出的异常不能大于父类， 故我们这里也不能抛出异常
                        e.printStackTrace();
                    }
                    System.out.println(this.currentThread().getName() + "卖出一张票，剩余" + (--num) + "张");
                }
            }
        }
    }


}