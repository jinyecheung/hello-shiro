package com.example.hello.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.shiro.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
