package com.example.hello.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.shiro.entity.User;
import com.example.hello.shiro.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDaoMapper extends BaseMapper<UserEntity> {
    User findByName(@Param("name") String name);
}
