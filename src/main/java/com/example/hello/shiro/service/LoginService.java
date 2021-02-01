package com.example.hello.shiro.service;


import com.example.hello.shiro.pojo.Role;
import com.example.hello.shiro.pojo.User;
import com.example.hello.shiro.pojovo.RoleVo;

import java.util.List;

public interface LoginService {
    User addUser(User user);

    Role addRole(Role role);

    User findByName(String name);

    List<RoleVo> findUserRoles(User user);

}
