package com.meng.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSellRunnable implements Runnable{
 
     //定义一共有 50 张票，继承机制开启线程，资源是共享的，所以不用加 static
     private int num = 50 ;
     //创建一个锁对象
     Lock l = new ReentrantLock();
     
     @Override
     public void run() {
         //票分 50 次卖完
         for ( int i = 0 ; i < 50 ;i ++){
             //获取锁
             l.lock();
             try {
                 if (num > 0 ){
                 //模拟卖一次票所需时间
                 Thread.sleep( 10 );
                 System.out.println(Thread.currentThread().getName()+ "卖出一张票，剩余" +(--num)+ "张" );
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             } finally {
                 //释放锁
                 l.unlock();
             }
             
             
         }
     }
     private void sell(){
         
     }
 
}