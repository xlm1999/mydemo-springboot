package com.meng.redis.lock.a;

import java.util.UUID;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Service1 {
    private static JedisPool pool = null;
    private DistributedLock lock = new DistributedLock();
    
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(500);
        // 设置最大空闲数
        config.setMaxIdle(100);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "localhost", 6379, 300000);
    }
    
    public void seckill() throws InterruptedException {
        String requestId = UUID.randomUUID().toString();
        lock.lock(pool, "resource", requestId, 3000);
        lock.unLock(pool, "resource", requestId);
    }
}