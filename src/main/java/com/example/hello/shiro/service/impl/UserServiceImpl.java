package com.example.hello.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hello.shiro.pojo.User;
import com.example.hello.shiro.mapper.UserDaoMapper;
import com.example.hello.shiro.pojovo.UserVo;
import com.example.hello.shiro.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDaoMapper, User> implements IUserService {
    @Override
    public Page<User> FindUserListPage(UserVo userVo) {
        Page<User> page = new Page<>(userVo.getCurrPage(),userVo.getPageSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        Page<User> userPage = this.baseMapper.selectPage(page, wrapper);
        return userPage;
    }
}
