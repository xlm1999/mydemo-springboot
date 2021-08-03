package com.meng;

public class TestWait implements Runnable {
    private final Object object=new Object();
    private boolean flag=true;
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        if(flag){
            this.testwait();
        }
        else {
            this.testnotify();
        }
    }
    public void testwait(){
        synchronized (object){
            try {
                System.out.println(Thread.currentThread().getName()+"线程开始执行。。。");
                Thread.sleep(1000);
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程执行结束。。。");
        }
    }
    public void testnotify(){
        synchronized (object){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            object.notify();
        }
    }
    public static void main(String[] args) {
        TestWait testWait=new TestWait();
        Thread thread=new Thread(testWait,"线程1");
        thread.start();
        Thread thread1=new Thread(testWait,"线程2");
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testWait.setFlag(false);
        Thread thread2=new Thread(testWait);
        thread2.start();

    }
}

