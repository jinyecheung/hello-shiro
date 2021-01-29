package com.example.hello.shiro.pojo;

import com.example.hello.shiro.pojovo.RoleVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String permission;
    private RoleVo role;

}