package com.example.hello.shiro.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hello.shiro.pojo.Permission;

import java.util.List;

public interface IPermissionService extends IService<Permission> {
    void savePermission(Permission p);

    void updatePermission(Permission p);

    void deletePermission(Permission p);

    List<Permission> findPermissionList(Permission p);
}
