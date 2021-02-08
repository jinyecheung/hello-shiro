package com.example.hello.shiro.controller;

import com.example.hello.shiro.pojo.User;
import com.example.hello.shiro.pojovo.UserVo;
import com.example.hello.shiro.service.IUserService;
import com.example.hello.shiro.util.IDUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object userList(UserVo userVo , Model model){
        //model.addAttribute("userList",userService.list());
        model.addAttribute("pageData",userService.FindUserListPage(userVo));
        return "user/userList";
    }

    // for test
    @RequestMapping("userListPage")
    @ResponseBody
    public Object userListPage(UserVo userVo , Model model){
        model.addAttribute("pageData",userService.FindUserListPage(userVo));
        return "user/userListPage";
    }

    @RequiresRoles("admin")
    //@RequiresPermissions("user:add")
    @RequestMapping("add")
    public String add(){
        return "user/addUser";
    }

    @RequestMapping("addAction")
    public String addAction(User user){
        user.setUserId(IDUtil.getID());
        userService.save(user);
        return "redirect:/user/userList";
    }
}
