package com.example.hello.shiro.controller;

import com.example.hello.shiro.entity.User;
import com.example.hello.shiro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 *  http://localhost:8080/user/userList
 *  http://localhost:8080/user/add
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("userList")
    public Object userList(Model model){
        model.addAttribute("userList",userService.list());
        return "user/userList";
    }

    @RequestMapping("add")
    public String add(){
        return "user/addUser";
    }

    @RequestMapping("addAction")
    public String addAction(User user){
        user.setUserId(UUID.randomUUID().toString());
        userService.save(user);
        return "redirect:/user/userList";
    }
}
