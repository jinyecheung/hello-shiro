package com.example.hello.shiro.controller;

import com.example.hello.shiro.pojo.Permission;
import com.example.hello.shiro.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/save")
    public String save(Permission p){
        permissionService.savePermission(p);
        return "redirect:/permission/list";
    }

    @RequestMapping("/update")
    public String update(Permission p){
        permissionService.updatePermission(p);
        return "sys/permissionList";
    }

    @RequestMapping("/delete")
    public String delete(Permission p){
        permissionService.deletePermission(p);
        return "sys/permissionList";
    }

    @RequestMapping("/list")
    public String list(Permission p,Model model){
        List<Permission> list = permissionService.findPermissionList(p);
        model.addAttribute("permissionList",list);
        return "sys/permissionList";
    }

    @RequestMapping("/{path}")
    public String path(@PathVariable("path") String path){
        return "sys/" + path;
    }
}
