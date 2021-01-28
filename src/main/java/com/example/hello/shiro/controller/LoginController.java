package com.example.hello.shiro.controller;


import com.example.hello.shiro.entity.Role;
import com.example.hello.shiro.entity.User;
import com.example.hello.shiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){
        return "sys/login";
    }

    @PostMapping("/login/loginAction")
    public String loginAction(@RequestBody User user,Model model){
        // 添加用户认证信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
        // 进行验证，这里可以捕获异常，然后返回对应信息
        SecurityUtils.getSubject().login(usernamePasswordToken);
        //
        return index(model);
        //return "okokokokok.";
    }

//    @RequestMapping("/error")
//    public String error(){
//        return "sys/error";
//    }

    /**
     * http://localhost:8080/index
     * http://localhost:8080/index/home
     */
    @RequestMapping("/index")
    public String home(){
        return "sys/index";
    }

    @RequestMapping("/index/home")
    public String index(Model model){
        model.addAttribute("name","hello-shiro,now is 2021.01.28");
        return "sys/home";
    }

    ///////////////////////////////////////////////////////////////////////////
    /**
     * POST登录
     * @param
     * @return
     */
//    @PostMapping(value = "/login")
//    public String login(@RequestBody User user) {
//        // 添加用户认证信息
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
//        // 进行验证，这里可以捕获异常，然后返回对应信息
//        SecurityUtils.getSubject().login(usernamePasswordToken);
//        return "login ok!";
//    }

    /**
     * 添加用户
     * @param user
     * @return
     */
//    @PostMapping(value = "/addUser")
//    public String addUser(@RequestBody User user) {
//        user = loginService.addUser(user);
//        return "addUser is ok! \n" + user;
//    }

    /**
     * 添加角色
     * @param role
     * @return
     */
//    @PostMapping(value = "/addRole")
//    public String addRole(@RequestBody Role role) {
//        role = loginService.addRole(role);
//        return "addRole is ok! \n" + role;
//    }

    /**
     * 注解的使用
     * @return
     */
//    @RequiresRoles("admin")
//    @RequiresPermissions("create")
//    @GetMapping(value = "/create")
//    public String create() {
//        return "Create success!";
//    }
//
//    @GetMapping(value = "/index")
//    public String index() {
//        return "index page!";
//    }
//
//    @GetMapping(value = "/error")
//    public String error() {
//        return "error page!";
//    }

    /**
     * 退出的时候是get请求，主要是用于退出
     * @return
     */
//    @GetMapping(value = "/login")
//    public String login() {
//
//        //return "please login page";
//        return "sys/login";
//    }
//
//    @GetMapping(value = "/logout")
//    public String logout() {
//        return "had logout";
//    }

    @ResponseBody
    @RequestMapping("/demo/test")
    public Object demotest(){
        Map<String,Object> map = new HashMap();
        map.put("ak",123321);
        map.put("bk",456789);
        map.put("ck",678900);
        map.put("dk",890981);
        return map;
    }
}