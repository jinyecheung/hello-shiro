package com.example.hello.shiro.service;


import com.example.hello.shiro.entity.Role;
import com.example.hello.shiro.entity.User;

public interface LoginService {
    User addUser(User user);

    Role addRole(Role role);

    User findByName(String name);
}
