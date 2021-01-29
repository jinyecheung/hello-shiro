package com.example.hello.shiro.pojovo;

import com.example.hello.shiro.pojo.Permission;
import com.example.hello.shiro.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleId;
    private String roleCode;
    private String roleName;
    private User user;
    private List<Permission> permissions;
}
