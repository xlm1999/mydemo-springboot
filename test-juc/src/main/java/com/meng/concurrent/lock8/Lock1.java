package com.meng.concurrent.lock8;

import java.util.concurrent.TimeUnit;

public class Lock1 {
    public static void main(String[] args) throws Exception{
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            phone2.call();
        },"b").start();

    }
}

class Phone {
    public synchronized void sendSms () throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + ":发短信");
    }

    public synchronized void call () {
        System.out.println(Thread.currentThread().getName() + ":打电话");
    }
    
    String s = "AND ( " +
            " '2' || SUBSTR (t2.NUM, 2, 4) || '00000000' IN ( " +
            " SELECT " +
            "  num " +
            " FROM " +
            "  T_SYS_DPT T " +
            " WHERE " +
            "  T .NUM = ( " +
            "  SELECT " +
            "   '2' || SUBSTR (t1.NUM, 2, 4) || '00000000' " +
            "  FROM " +
            "   T_SYS_EMP T " +
            "  LEFT JOIN T_SYS_DPT t1 ON t1. ID = T .DEPARTMENTID " +
            "  WHERE " +
            "   T .userid = '5ab7d572-2eb7-48ac-a15c-a679cc0b7df5' " +
            "  AND T .ISVALID = 'Y' " +
            "  ) " +
            " OR T .num IN ( " +
            "  SELECT " +
            "  '2' || SUBSTR (t1.NUM, 2, 4) || '00000000' " +
            "  FROM " +
            "  t_sys_prtdpt T " +
            "  LEFT JOIN T_SYS_DPT t1 ON t1. ID = T .deptid " +
            "  WHERE " +
            "  T .userid = '5ab7d572-2eb7-48ac-a15c-a679cc0b7df5' " +
            "  AND T .ISVALID = 'Y' " +
            "  AND SUBSTR (t1. NAME, 0, 4) != '(废弃)' " +
            " ) " +
            " ) " +
            ")";
}