package com.meng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@Controller
public class MyContorller {
//    @Resource
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")

    public String hello() {
        return "hello";
    }

    @RequestMapping("/rest-get")
    @ResponseBody
    public TestEntity sayHello() {
        TestEntity entity = restTemplate.getForObject("http://localhost:8080/testGet", TestEntity.class);
        return entity;
    }

}
