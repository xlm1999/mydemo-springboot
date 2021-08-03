package com.meng;

public class SleepLockTest {
    
     public static void main(String[] args) throws InterruptedException {
         
         ThreadB t1 = new ThreadB("t1"); 
         ThreadB t2 = new ThreadB("t2"); 
         t1.start();

         t2.start();
         t2.join();
     }
}

class ThreadB extends Thread{

    private  Object obj = new Object();

    public ThreadB(String name){
        super(name);
    }

    public void run(){
        synchronized(obj){
            try {
                for(int i=0; i <10; i++){
                    System.out.printf("%s: %d\n", this.getName(), i);
                    // i能被4整除时，休眠100毫秒
                    if (i%4 == 0)
                        Thread.sleep(3000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}