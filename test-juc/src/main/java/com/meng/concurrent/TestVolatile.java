package com.meng.concurrent;

public class TestVolatile {
    public static void main(String[] args){
        MyThread td = new MyThread();
        new Thread(td).start();

        while(true){
            synchronized (td) {
                if(td.isFlag()){
                    System.out.println("########");
                    break;
                }
            }

        }
    }
}

class MyThread implements Runnable {

    private boolean  flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;

        System.out.println("flag = " + flag);

    }
}
