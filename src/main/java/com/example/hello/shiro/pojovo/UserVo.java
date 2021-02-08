package com.example.hello.shiro.pojovo;

import com.example.hello.shiro.util.BasePageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserVo extends BasePageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String userName;

    private String passWord;

    private String phone;

    private String email;

    private List<RoleVo> roles;

}
