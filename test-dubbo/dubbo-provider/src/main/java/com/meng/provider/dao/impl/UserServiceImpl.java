package com.meng.provider.dao.impl;

import com.meng.api.entity.User;
import com.meng.api.service.UserService;
import com.meng.provider.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        System.out.println("UserService 实现类中：注册用户");
        userMapper.insert(user);
    }

    @Override
    public User getUserById(Long id) {
        System.out.println("UserService 实现类中：根据id查询用户");
        return userMapper.selectById(id);
    }
}

