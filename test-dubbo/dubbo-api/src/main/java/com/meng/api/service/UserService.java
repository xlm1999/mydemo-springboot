package com.meng.api.service;

import com.meng.api.entity.User;

public interface UserService {
    void register(User user);
    User getUserById(Long id);
}
