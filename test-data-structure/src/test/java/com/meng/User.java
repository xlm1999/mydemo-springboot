package com.meng;

public class User {
    private int userNumber  = 0 ;

    public User(){
        userNumber ++;
    }

    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        System.out.println("user1 userNumber：" + user1.userNumber);
        System.out.println("user2 userNumber：" + user2.userNumber);
    }
}
