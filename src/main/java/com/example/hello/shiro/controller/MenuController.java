package com.example.hello.shiro.controller;

import com.example.hello.shiro.pojo.Menu;
import com.example.hello.shiro.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zhangjinpei
 * @version 1.0
 * @date 2021/2/3 14:15
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @RequestMapping("/list")
    public String list(Menu m, Model model){
        List<Menu> menuList = menuService.findMenuList(m);
        model.addAttribute("menuList",menuList);
        return "menu/menuList";
    }

    @RequestMapping("/save")
    public String saveMenu(Menu m){
        menuService.saveMenu(m);
        return "redirect:/menu/list";
    }

    @RequestMapping("/update")
    public String updateMenu(Menu m){
        menuService.updateMenu(m);
        return "redirect:/menu/list";
    }

    @RequestMapping("/delete")
    public String deleteMenu(Menu m){
        menuService.deleteMenu(m);
        return "redirect:/menu/list";
    }

    @RequestMapping("/menuAdd")
    public String menuAddPage(Model model){
        List<Menu> menuParentList = menuService.findMenuParentList();
        return "menu/menuAdd";
    }
    @RequestMapping("/{path}")
    public String path(@PathVariable("path") String path){
        return "menu/" + path;
    }
}
