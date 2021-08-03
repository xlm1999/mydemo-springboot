package com.meng.jmeter;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jmeter")
@Scope("singleton")
public class JmeterController {
    private Integer count = 100;
    @GetMapping(value = {"/test"})
    public String test() throws InterruptedException {
        if (count <= 0) {
            System.out.println("已经没有count了");
            return "end";
        }
        //模拟网络延时
        Thread.sleep(10);
        System.out.println("现有count数量:" + --count);
        return "ok";
    }
}
