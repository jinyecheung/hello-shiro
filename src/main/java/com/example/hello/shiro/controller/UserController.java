package com.example.hello.shiro.controller;

import com.example.hello.shiro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  http://localhost:8080/user/userList
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("userList")
    public Object userList(Model model){
        model.addAttribute("userList",userService.list());
        return "sys/userList";
    }
}
