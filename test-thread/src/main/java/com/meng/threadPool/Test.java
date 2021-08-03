package com.meng.threadPool;

import java.util.concurrent.*;

public class Test {
     public static void main(String[] args) {   
//         ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                 new ArrayBlockingQueue<Runnable>(5));
         //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
         ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

         int maximumPoolSize = executor.getMaximumPoolSize();
         int corePoolSize = executor.getCorePoolSize();
         System.out.println("最大线程数" + maximumPoolSize);
         System.out.println("核心线程数" + corePoolSize);
         for(int i=0;i<1;i++){
             MyTask myTask = new MyTask(i);
             executor.execute(myTask);
             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
         }
         System.out.println("核心线程数" + corePoolSize);
         executor.shutdown();
     }
}