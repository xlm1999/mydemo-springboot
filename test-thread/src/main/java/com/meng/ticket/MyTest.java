package com.meng.ticket;

public class MyTest {
    public static void main(String[] args) {
        TicketSellRunnable t = new TicketSellRunnable();

        Thread t1 = new Thread(t, "A窗口" );
        Thread t2 = new Thread(t, "B窗口" );
        Thread t3 = new Thread(t, "C窗口" );

        t1.start();
        t2.start();
        t3.start();
    }
}
