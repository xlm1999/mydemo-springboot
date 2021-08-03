package com.meng.controller;

import com.meng.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class MyController {

    @RequestMapping("/hello")
    public String test1(Model model) {
        User user = new User();
        user.setAge(21);
        user.setName("Jackson");
        user.setFriend(new User("李小龙", 30, null));

        model.addAttribute("user", user);
        model.addAttribute("msg","haohao");
        model.addAttribute("today", new Date());
        return "hello";
    }
}
