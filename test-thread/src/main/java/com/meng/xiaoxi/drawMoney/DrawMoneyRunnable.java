package com.meng.xiaoxi.drawMoney;

public class DrawMoneyRunnable implements Runnable{
    
    private Account account;
    private double drawAmount;

    public DrawMoneyRunnable(Account account, double drawAmount) {
        super();
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run() {
        if (account.getBalance() >= drawAmount) {  //1
            System.out.println("取钱成功， 取出钱数为：" + drawAmount);
            double balance = account.getBalance() - drawAmount;
            account.setBalance(balance);
            System.out.println("余额为：" + balance);
        }
    }

}