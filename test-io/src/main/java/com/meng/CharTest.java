package com.meng;

import java.io.IOException;

public class CharTest{
public static void main(String[] args) {
         try{   
         System.out.print("Enter a Char:");   
         char i = (char)System.in.read();   
         System.out.println("Yout Enter Char is:" + i);           }   
         catch(IOException e){
            e.printStackTrace();   
         }   
    }
}