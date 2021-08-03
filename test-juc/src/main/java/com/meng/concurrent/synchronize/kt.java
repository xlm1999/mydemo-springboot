package com.meng.concurrent.synchronize;

public class kt {
    public static void main(String[] args) {
        System.out.println("使用关键字synchronized");
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(new SyncThread(), "A");
        Thread thread2 = new Thread(new SyncThread(), "B");
        thread1.start();
        thread2.start();
    }
}
class SyncThread implements Runnable {
    private  int count;
    public SyncThread() {
        count = 0;
    }
    public  void run() {
       synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程名:"+Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getCount() {
        return count;
    }
}