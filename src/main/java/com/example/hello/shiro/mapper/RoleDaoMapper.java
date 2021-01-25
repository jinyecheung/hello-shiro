package com.example.hello.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDaoMapper extends BaseMapper<Role> {
}
