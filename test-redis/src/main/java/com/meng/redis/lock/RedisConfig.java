package com.meng.redis.lock;
 
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
@Configuration
@PropertySource("classpath:config/redis.properties")
@Slf4j
public class RedisConfig {
 
    @Value("${spring.redis.host}")
    private String host;
 
    @Value("${spring.redis.port}")
    private int port;
 
    @Value("${spring.redis.timeout}")
    private int timeout;
 
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
 
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;
 
    @Value("${spring.redis.password}")
    private String password;
 
    @Value("${spring.redis.block-when-exhausted}")
    private boolean  blockWhenExhausted;
 
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
 
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;
 
    @Bean
    public JedisPool redisPoolFactory()  throws Exception{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,null);
 
        log.info("JedisPool注入成功！");
        log.info("redis地址：" + host + ":" + port);
        System.out.println(new Jedis("118.24.218.169",6379).ping()); //注意将ip和端口号写对
        return  jedisPool;
    }

}