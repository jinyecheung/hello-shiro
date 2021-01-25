package com.example.hello.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * http://localhost:8080/index
 */
@Controller
public class DemoIndex {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","jfjfjfj");
        return "index";
    }
}
