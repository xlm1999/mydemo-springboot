package com.meng.redislock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisLockController {
    //假设库存编号是00001
    private String key = "stock:00001";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 扣减库存 synchronized同步锁
     */
    @RequestMapping("/deductStock")
    public String deductStock(){
        synchronized (this){
            //获取当前库存
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get(key));
            if(stock>0){
                int afterStock = stock-1;
                stringRedisTemplate.opsForValue().set(key,afterStock+"");//修改库存
                System.out.println("扣减库存成功，剩余库存"+afterStock);
            }else {
                System.out.println("扣减库存失败");
            }
        }
        return "ok";
    }
}
