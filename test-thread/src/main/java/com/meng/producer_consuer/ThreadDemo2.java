package com.meng.producer_consuer;

public class ThreadDemo2 {

    public static void main(String[] args){
        MyRunable2 mr2 = new MyRunable2();
        Thread t = new Thread(mr2);
        t.start();
        MyRunable3 mr3 = new MyRunable3();
        Thread t2 = new Thread(mr3);
        //t2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"=========>"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==20){
                    t.interrupt();//中断线程,只是作了一个中断标记，用于测试interrupt方法
                //mr3.flag = false; //用于测试标记中断

                break;
            }

        }

    }

}

 

class MyRunable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(Thread.interrupted()){//测试中断状态，此方法会把中断状态清除
                //....
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}

//标记中断
class MyRunable3 implements Runnable{
    public boolean flag = true;
    public MyRunable3(){
        flag = true;
    }

    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"==="+(i++));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}