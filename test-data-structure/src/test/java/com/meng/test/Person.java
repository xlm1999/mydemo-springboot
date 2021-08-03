package com.meng.test;

import java.io.Serializable;

public class Person implements Serializable {
    //本类可以序列化
    private String name ; 
    private int age ;
    public Person(String name,int age)
    { 
        this.name = name ; this.age = age ;
    } 
    public String toString()
    {
        return "姓名：" + this.name + "，年龄" + this.age ;
    } 
}