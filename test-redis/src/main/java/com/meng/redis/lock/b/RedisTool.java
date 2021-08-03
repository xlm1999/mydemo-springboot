package com.meng.redis.lock.b;

import java.util.Collections;
import java.util.UUID;

import redis.clients.jedis.Jedis;

public class RedisTool {
    
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final String SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    private static final Long RELEASE_SUCCESS = 1L;
    
    // test
    private int count = 0;
    
    /**
     * 获取请求Id 
     * @return 返回UUID
     */
    public static String getRequestId(){
        return UUID.randomUUID().toString();
    }
    
    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
 
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
 
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
    
    
    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
 
        Object result = jedis.eval(SCRIPT, Collections.singletonList(lockKey), Collections.singletonList(requestId));
 
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        RedisTool redisTool = new RedisTool();
        redisTool.testDistributedLock();
    }
    
    public void testDistributedLock() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Jedis jedis = new Jedis("localhost", 6379);
                    String lockKey = "lock";
                    String requestId = getRequestId();
                    // 加锁
                    if (tryGetDistributedLock(jedis, lockKey, requestId, 10)) {
                        count++;
                        System.out.println(requestId + "获取锁成功:" + count);
                        // 解锁
                        releaseDistributedLock(jedis, lockKey, requestId);
                    } else {
                        System.out.println(requestId + ": 获取锁失败");
                    }

                }
            }).start();
        }
    }
}