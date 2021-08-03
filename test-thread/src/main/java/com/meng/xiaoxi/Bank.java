package com.meng.xiaoxi;

import java.util.Date;

public class Bank {

    private int count =0;//账户余额  

    //存钱  
    public synchronized void addMoney(int money){
        count +=money;  
        System.out.println(new Date() +"存进："+money);
    }  

    //取钱  
    public synchronized void subMoney(int money){
        if(count-money < 0){  
            System.out.println("余额不足");  
            return;  
        }  
        count -=money;  
        System.out.println(new Date()+"取出："+money);
    }  

    //查询  
    public void lookMoney(){  
        System.out.println("账户余额："+count);  
    }  
}

class SyncThreadTest {

    public static void main(String args[]){
        final Bank bank=new Bank();

        Thread tadd=new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    bank.addMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");

                }
            }
        });

        Thread tsub = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while(true){
                    bank.subMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        tsub.start();

        tadd.start();
    }

}