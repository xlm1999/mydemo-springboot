package com.meng.test;


public class Test2 {
    public static void change(String s){
        s="zhangsan";
    }

    public static void main(String[] args) {
        String s=new String("lisi");
        System.out.println(s);
        change(s);
        System.out.println(s);
    }
}
