package com.meng.xiaoxi.ProducerConsumer.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource1 {

    /*资源序号*/
    private int number = 0;
    /*资源标记*/
    private boolean flag = false;
    
    private Lock lock = new ReentrantLock();
    //使用lock建立生产者的condition对象
    private Condition condition_pro = lock.newCondition();
    //使用lock建立消费者的condition对象
    private Condition condition_con = lock.newCondition(); 


    /**
     * 生产资源
     */
    public void create() throws InterruptedException {
        
        try{
            lock.lock();
            //先判断标记是否已经生产了，如果已经生产，等待消费
            while(flag){
                //生产者等待
                condition_pro.await();
            }
            //生产一个
            number++;
            System.out.println(Thread.currentThread().getName() + "生产者------------" + number);
            //将资源标记为已经生产
            flag = true;
            //生产者生产完毕后，唤醒消费者的线程（注意这里不是signalAll)
            condition_con.signal();
        }finally{
            lock.unlock();
        }
    }

    /**
     * 消费资源
     */
    public void destroy() throws InterruptedException{

        try{
            lock.lock();
            //先判断标记是否已经消费了，如果已经消费，等待生产
            while(!flag){
                //消费者等待
                condition_con.await();
            }
            
            System.out.println(Thread.currentThread().getName() + "消费者****" + number);
            //将资源标记为已经消费
            flag = false;
            //消费者消费完毕后，唤醒生产者的线程
            condition_pro.signal();
        }finally{
            lock.unlock();
        }
    }
}