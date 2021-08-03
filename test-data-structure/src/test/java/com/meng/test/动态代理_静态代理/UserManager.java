package com.meng.test.动态代理_静态代理;

public interface UserManager {
    void addUser(String userId, String userName);
    void delUser(String userId);
    String findUser(String userId);
    void modifyUser(String userId, String userName);
}
