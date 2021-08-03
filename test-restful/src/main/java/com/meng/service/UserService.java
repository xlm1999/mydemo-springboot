package com.meng.service;

import com.meng.entity.User;
import com.meng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userMapper.addUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateUser(User user) {
        boolean flag=false;
        try{
            userMapper.updateUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            userMapper.deleteUser(id);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public User findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }


    public List<User> findAll() {
        return userMapper.findAllUser();
    }
}
