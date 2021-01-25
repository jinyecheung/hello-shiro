package com.example.hello.shiro.service.impl;

import com.example.hello.shiro.entity.Permission;
import com.example.hello.shiro.entity.Role;
import com.example.hello.shiro.entity.User;
import com.example.hello.shiro.mapper.RoleDaoMapper;
import com.example.hello.shiro.mapper.UserDaoMapper;
import com.example.hello.shiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDaoMapper userDao;
    @Autowired
    private RoleDaoMapper roleDao;

    //添加用户
    @Override
    public User addUser(User user) {
        userDao.insert(user);
        return user;
    }

    //添加角色
    @Override
    public Role addRole(Role role) {
        User user = userDao.findByName(role.getUser().getName());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleDao.insert(role);
        return role;
    }

    //查询用户通过用户名
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
