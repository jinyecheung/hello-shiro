package com.example.hello.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Z_TEST_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Role> roles;

    @TableField("password")
    private String password;

    @TableField("name")
    private String name;

    @TableField("id")
    private Long id;
}
