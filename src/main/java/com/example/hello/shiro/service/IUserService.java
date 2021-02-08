package com.example.hello.shiro.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hello.shiro.pojo.User;
import com.example.hello.shiro.pojovo.UserVo;

public interface IUserService extends IService<User> {
    Page<User> FindUserListPage(UserVo userVo);
}
