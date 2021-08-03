package com.meng.service;

import com.meng.entity.User;

public interface LoginService {
    public User getUserByName(String getMapByName);
    User getMapByName(String userName);
}
