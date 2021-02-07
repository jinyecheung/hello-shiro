package com.example.hello.shiro.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.hello.shiro.pojo.Menu;
import com.example.hello.shiro.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        return "menu/menuAdd";
    }

    //新增二级菜单
    @RequestMapping("/menuAdd2")
    public String menuAddPage2(Model model){
        List<Menu> menuParentList = menuService.findMenuParentList();
        model.addAttribute("menuParentList",menuParentList);
        return "menu/menuAdd2";
    }

    @RequestMapping("/{path}")
    public String path(@PathVariable("path") String path){
        return "menu/" + path;
    }

    @RequestMapping("/findWebMenuList")
    @ResponseBody
    public Object findWebMenuList(Menu menu){
        List<Map<String,Object>> findWebMenuList = new ArrayList<>();
        List<Menu> menuList = menuService.findMenuList(menu);
        if(CollectionUtils.isNotEmpty(menuList)){
            for(Menu m : menuList){
                Map<String,Object> dataMap = new LinkedHashMap<>();
                dataMap.put("F_ModuleId",m.getMenuId());
                dataMap.put("F_ParentId",StringUtils.isBlank(m.getParentMenuId()) ? "0" : m.getParentMenuId());
                dataMap.put("F_EnCode",m.getMenuCode());
                dataMap.put("F_FullName",m.getMenuName());
                dataMap.put("F_Icon","fa fa-desktop");
                dataMap.put("F_UrlAddress",StringUtils.isBlank(m.getParentMenuId()) ? "/default" : m.getMenuUrl());
                dataMap.put("F_Target",StringUtils.isBlank(m.getParentMenuId()) ? "expand" : "iframe");
                dataMap.put("F_IsMenu",StringUtils.isBlank(m.getParentMenuId()) ? "0" : "1");
                dataMap.put("F_AllowExpand","1");
                dataMap.put("F_IsPublic","0");
                dataMap.put("F_AllowEdit",null);
                dataMap.put("F_AllowDelete",null);
                dataMap.put("F_SortCode","1");
                dataMap.put("F_DeleteMark","0");
                dataMap.put("F_EnabledMark","1");
                dataMap.put("F_Description",null);
                dataMap.put("F_CreateDate",null);
                dataMap.put("F_CreateUserId",null);
                dataMap.put("F_CreateUserName",null);
                dataMap.put("F_ModifyDate","2021-02-05 16:52:16");
                dataMap.put("F_ModifyUserId","System");
                dataMap.put("F_ModifyUserName","超级管理员");
                findWebMenuList.add(dataMap);
            }
        }
        return findWebMenuList;
    }
}
