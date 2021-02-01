package com.example.hello.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.shiro.pojo.Permission;
import com.example.hello.shiro.pojo.Role;
import com.example.hello.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDaoMapper extends BaseMapper<Role> {
    //List<Role> findUserRoles(@Param("user") User user);

    /**
     * 根据userId查询用户所有角色
     * @param user User
     * @return List List
     */
    List<Role> findUserRoles(User user);

    /**
     * 根据userId查询用户所有权限
     * @param user User
     * @return List List
     */
    List<Permission> findUserPermissions(User user);
}
