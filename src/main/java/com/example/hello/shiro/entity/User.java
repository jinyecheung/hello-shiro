package com.example.hello.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User extends UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Role> roles;

}
