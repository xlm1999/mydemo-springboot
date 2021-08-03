package com.meng;

public class YieldTest {
    
    public static void main(String[] args){
        Thread1 t1 = new Thread1("t1");
        Thread1 t2 = new Thread1("t2");
        
        t1.start();
        t2.start();
        
    }

}

class Thread1 extends Thread{

    public Thread1(String name){
        super(name);
    }

    public synchronized void run(){
        for(int i=0; i <10; i++){
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
            // i整除4时，调用yield
            if (i%4 == 0){
                Thread.yield();
            }

        }
    }
}