package com.example.hello.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hello.shiro.mapper.MenuMapper;
import com.example.hello.shiro.pojo.Menu;
import com.example.hello.shiro.service.IMenuService;
import com.example.hello.shiro.util.IDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.list(wrapper);
    }

    @Override
    public List<Menu> findMenuParentList() {
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.isNull(Menu::getParentMenuId);
        return this.list(wrapper);
    }
}
