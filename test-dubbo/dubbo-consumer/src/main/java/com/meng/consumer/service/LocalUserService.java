package com.meng.consumer.service;

import com.meng.api.entity.User;
import org.apache.dubbo.config.annotation.Service;

/**
 * consumer子Module的本地Service
 */
@Service
public interface LocalUserService {
    void register(User user);
    User getById(Long id);
}

