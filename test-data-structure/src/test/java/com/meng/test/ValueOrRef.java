package com.meng.test;

import java.io.Serializable;

public class ValueOrRef {
    public static void main(String[] args) {
        Person2 zhangsan = new Person2("ZHANG San");
        changePerson(zhangsan);
        zhangsan.printName();
    }
    public static void changePerson(Person2 person){
        //person.changeName("LI Si");
        person = new Person2("LI Si");

    }
}

class Person2 implements Serializable {
    String name = "default";
    public Person2(String name) {
        this.name = name;
    }
    public void changeName(String name){
        this.name = name;
    }
    void printName() {
        System.out.println(this.name);
    }
}