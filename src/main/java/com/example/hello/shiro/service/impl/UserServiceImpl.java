package com.example.hello.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hello.shiro.entity.User;
import com.example.hello.shiro.mapper.UserDaoMapper;
import com.example.hello.shiro.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDaoMapper, User> implements IUserService {
}
