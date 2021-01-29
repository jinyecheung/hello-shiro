package com.example.hello.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hello.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDaoMapper extends BaseMapper<User> {
    User findByName(@Param("name") String name);
}
