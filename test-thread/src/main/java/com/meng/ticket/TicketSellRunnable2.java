package com.meng.ticket;

public class TicketSellRunnable2 implements Runnable{

     //定义一共有 50 张票，继承机制开启线程，资源是共享的，所以不用加 static
     private int num = 50 ;
     
     @Override
     public void run() {
         //票分 50 次卖完
         for ( int i = 0 ; i < 50 ;i ++){
             //这里我们使用当前对象的字节码对象作为同步锁
             synchronized ( this .getClass()) {
                 if (num > 0 ){
                     try {
                         //模拟卖一次票所需时间
                         Thread.sleep( 10 );
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName()+ "卖出一张票，剩余" +(--num)+ "张" );
                 }
             }

         }
     }
 
}