package com.meng;

import java.io.*;


public class IOPractice {

    public static void main(String[] args) throws IOException {
        // 第1步：使用File类找到一个文件    
             File f = new File("d:/1.txt");
        // 第2步：通过子类实例化父类对象     
             Writer out = new FileWriter(f);
        // 通过对象多态性进行实例化    
        // 第3步：进行写操作    
             String str = "Hello World! 你好，世界";
        // 准备一个字符串    
             byte b[] = str.getBytes();          
        // 字符串转byte数组    
             out.write(str);
        // 将内容输出    
         // 第4步：关闭输出流    
             out.close();
        // 此时没有关闭    
                }    
}