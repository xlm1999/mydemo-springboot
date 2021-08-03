package com.meng.xiaoxi.drawMoney;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("123456", 1000);
        DrawMoneyRunnable drawMoneyRunnable =
                new DrawMoneyRunnable(account, 700);
        Thread myThread1 = new Thread(drawMoneyRunnable);
        Thread myThread2 = new Thread(drawMoneyRunnable);
        myThread1.start();
        Thread.sleep(1000);
        myThread2.start();
    }

}