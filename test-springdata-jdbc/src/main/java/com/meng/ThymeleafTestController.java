package com.meng;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafTestController {
    @RequestMapping("testThemyleaf")
    public String test() {
        return "thymeleef";
    }

    @RequestMapping("testThemyleaf2")
    public String test2(Model model) {
        model.addAttribute("msg", "haohao");
        return "thymeleef";
    }

}
