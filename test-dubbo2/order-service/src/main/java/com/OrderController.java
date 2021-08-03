package com;

import com.meng.User;
import com.meng.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Reference  //注入要调用的服务
    private UserService userService;

    @Reference  //注入要调用的服务
    private UserService userServiceNew;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id){
        //调用服务
        User user= userService.findUserById(id);
        return user;
    }

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String sayHelo(@PathVariable String name){
       return  userService.sayHello(name);
    }
    
}