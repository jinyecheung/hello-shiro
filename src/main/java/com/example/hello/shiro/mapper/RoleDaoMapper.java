package com.example.hello.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.shiro.pojo.Role;
import com.example.hello.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDaoMapper extends BaseMapper<Role> {
    //List<Role> findUserRoles(@Param("user") User user);
    List<Role> findUserRoles(User user);
}
