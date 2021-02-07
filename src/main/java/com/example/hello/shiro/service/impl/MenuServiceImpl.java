package com.example.hello.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hello.shiro.mapper.MenuMapper;
import com.example.hello.shiro.pojo.Menu;
import com.example.hello.shiro.service.IMenuService;
import com.example.hello.shiro.util.IDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjinpei
 * @version 1.0
 * @date 2021/2/3 14:14
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Override
    public void saveMenu(Menu m) {
        m.setMenuId(IDUtil.getID());
        this.save(m);
    }

    @Override
    public void updateMenu(Menu m) {
        this.updateById(m);
    }

    @Override
    public void deleteMenu(Menu m) {
        this.removeById(m);
    }

    @Override
    public List<Menu> findMenuList(Menu m) {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(m.getMenuCode())){
            wrapper.eq(Menu::getMenuCode,m.getMenuCode());
        }
        if(StringUtils.isNotBlank(m.getMenuName())){
            wrapper.like(Menu::getMenuName,m.getMenuName());
        }
        if(StringUtils.isNotBlank(m.getParentMenuId())){
            wrapper.eq(Menu::getParentMenuId,m.getParentMenuId());
        }
        if(StringUtils.isNotBlank(m.getMenuType())){
            wrapper.eq(Menu::getMenuType,m.getMenuType());
        }
        if(StringUtils.isNotBlank(m.getShowFlag())){
            wrapper.eq(Menu::getShowFlag,m.getShowFlag());
        }
        if(StringUtils.isNotBlank(m.getDeleteFlag())){
            wrapper.eq(Menu::getDeleteFlag,m.getDeleteFlag());
        }
        wrapper.orderByAsc(Menu::getMenuCode);
        return this.list(wrapper);
    }

    @Override
    public List<Menu> findMenuParentList() {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.isNull(Menu::getParentMenuId).or().eq(Menu::getParentMenuId,"");
        return this.list(wrapper);
    }

    @Override
    public List<Map<String, Object>> findWebHomeMenuList(Menu menu) {
        List<Map<String,Object>> findWebMenuList = new ArrayList<>();
        List<Menu> menuList = this.findMenuList(menu);
        if(CollectionUtils.isNotEmpty(menuList)){
            for(Menu m : menuList){
                Map<String,Object> dataMap = new LinkedHashMap<>();
                dataMap.put("F_ModuleId",m.getMenuId());
                dataMap.put("F_ParentId", com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(m.getParentMenuId()) ? "0" : m.getParentMenuId());
                dataMap.put("F_EnCode",m.getMenuCode());
                dataMap.put("F_FullName",m.getMenuName());
                dataMap.put("F_Icon","fa fa-desktop");
                dataMap.put("F_UrlAddress", com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(m.getParentMenuId()) ? "/default" : m.getMenuUrl());
                dataMap.put("F_Target", com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(m.getParentMenuId()) ? "expand" : "iframe");
                dataMap.put("F_IsMenu", com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(m.getParentMenuId()) ? "0" : "1");
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
