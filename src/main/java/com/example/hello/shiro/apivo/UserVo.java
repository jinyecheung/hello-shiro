package com.example.hello.shiro.apivo;

import com.example.hello.shiro.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String userName;

    private String passWord;

    private String phone;

    private String email;

    private List<Role> roles;

}
