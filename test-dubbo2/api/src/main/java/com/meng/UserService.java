package com.meng;

public interface UserService {
    User findUserById(Integer id);
    String sayHello(String name);
}