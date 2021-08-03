package com.meng;


import org.apache.dubbo.config.annotation.Service;

//此处的@Service是dubbo下的注解，不是spring的注解
@Service
public class UserService2Impl implements UserService2 {
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("haohao");
        return user;
    }

    @Override
    public String sayHello(String name) {
        return "你好" + name;
    }
}