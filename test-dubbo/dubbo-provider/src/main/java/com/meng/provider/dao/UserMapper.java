package com.meng.provider.dao;

import com.meng.api.entity.User;

/**
 * 模拟数据库访问
 */
public interface UserMapper {
    void insert(User user);
    User selectById(Long id);
}