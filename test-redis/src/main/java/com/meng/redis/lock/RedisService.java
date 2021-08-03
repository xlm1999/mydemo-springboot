package com.meng.redis.lock;
 
public interface RedisService {
 
    boolean  lock(String key, String uuid);
 
    boolean  unlock(String key, String uuid);
}