package com.example.hello.shiro.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hello.shiro.pojo.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {
    void saveMenu(Menu m);

    void updateMenu(Menu m);

    void deleteMenu(Menu m);

    List<Menu> findMenuList(Menu m);

    List<Menu> findMenuParentList();
}
