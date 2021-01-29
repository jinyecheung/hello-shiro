package com.example.hello.shiro.controller;


import com.example.hello.shiro.entity.User;
import com.example.hello.shiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String loginAction(User user,Model model){
        // 添加用户认证信息
        //UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
        // 进行验证，这里可以捕获异常，然后返回对应信息
        //SecurityUtils.getSubject().login(usernamePasswordToken);
        //
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
        try {
            SecurityUtils.getSubject().login(token);
        }catch (IncorrectCredentialsException e){
            token.clear();
            model.addAttribute("errorMsg","密码错误");
            return "/sys/error";
        }
        return index();
    }

    /**
     * http://localhost:8080/index
     * http://localhost:8080/index/home
     */
    @RequestMapping("/login/index")
    public String index(){
        return "sys/index";
    }

    @RequestMapping("/index/home")
    public String home(Model model){
        model.addAttribute("name","hello-shiro,now is 2021.01.28");
        return "sys/home";
    }

    @RequestMapping("/sys/error")
    public String errorPage(){
        return "sys/error";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
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

    /**
     * 请求demo测试案例
     * @return
     */
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

    /**
     * 登录时，认证异常捕获demo案例
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/login/demo")
    public String loginDemo(String username, String password, HttpServletRequest request) {
        try {
            Subject user = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                user.login(token);
            } catch (LockedAccountException lae) {
                token.clear();
                request.setAttribute("error", "用户已经被锁定不能登录，请与管理员联系！");
                return "/login";
            } catch (ExcessiveAttemptsException e) {
                token.clear();
                request.setAttribute("error", "账号：" + username + " 登录失败次数过多,锁定10分钟!");
                return "/login";
            } catch (AuthenticationException e) {
                token.clear();
                request.setAttribute("error", "用户或密码不正确！");
                return "/login";
            }
            request.removeAttribute("error");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "登录异常，请联系管理员！");
            return "/login";
        }
        return "redirect:index.shtml";
    }

}