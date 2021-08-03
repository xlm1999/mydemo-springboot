package com.meng.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private String name;
    private int age;
//    @Autowired
    private Cat cat;
    @Autowired(required = false)
    @Qualifier("dog")
    private Dog dog;
    private List favorite;

    public Student() {
        System.out.println("student类的默认构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public List getFavorite() {
        return favorite;
    }

    public void setFavorite(List favorite) {
        this.favorite = favorite;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cat=" + cat +
                ", dog=" + dog +
                ", favorite=" + favorite +
                '}';
    }
}
