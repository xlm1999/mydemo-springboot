package com.meng.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo
{
    //序列化 
    public static void main(String[] args) throws Exception 
    {
        //序列化后生成指定文件路径 
        File file = new File("D:" + File.separator + "person.ser") ;
        ObjectOutputStream oos = null ;
        //装饰流（流）
        oos = new ObjectOutputStream(new FileOutputStream(file)) ;
        //实例化类 
        Person per = new Person("张三",30) ;
        oos.writeObject(per) ;
        //把类对象序列化
        oos.close() ;
    } 
}