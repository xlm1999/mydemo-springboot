package com.meng.consumer.controller;

import com.meng.api.entity.User;
import com.meng.consumer.service.LocalUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
//    @Autowired
//    private LocalUserService localUserService;
    @Reference
    private LocalUserService localUserService;

    @RequestMapping("findUser")
    public User findUser(Long id){
        return localUserService.getById(id);
    }

    @RequestMapping("registerUser")
    public String register(User user){
        localUserService.register(user);
        return "注册用户成功";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
