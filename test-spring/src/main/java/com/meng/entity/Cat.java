package com.meng.entity;

public class Cat {

    public Cat() {
        System.out.println("Cat类的默认构造方法");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    public void shout(){
        System.out.println("小猫叫...");
    }
}
