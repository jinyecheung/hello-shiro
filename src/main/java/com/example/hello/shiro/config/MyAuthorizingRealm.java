package com.example.hello.shiro.config;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.hello.shiro.pojovo.RoleVo;
import com.example.hello.shiro.pojo.Permission;
import com.example.hello.shiro.pojovo.UserVo;
import com.example.hello.shiro.pojo.User;
import com.example.hello.shiro.service.LoginService;
import com.example.hello.shiro.util.BeanConvertUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *  实现AuthorizingRealm接口用户用户认证
 */
public class MyAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /**
     * 用户认证
     * 被调用 org.apache.shiro.realm.AuthenticatingRealm#getAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        // 获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = loginService.findByName(name);
        String ak = user.getUserId();
        String ab = user.getUserName();
        String ac = user.getPassWord();
        if (user == null) {
            // 这里返回后会报出对应异常
            return null;
        } else {
            // 这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name,
                    user.getPassWord(), getName());
            return simpleAuthenticationInfo;
        }
    }

    /**
     * 角色权限和对应权限添加
     * 被调用 org.apache.shiro.realm.AuthorizingRealm#getAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        // 查询用户名称
        User user = loginService.findByName(name);
        UserVo userVo = BeanConvertUtil.convertBean(user,UserVo.class);
        List<RoleVo> userRoles = loginService.findUserRoles(user);
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if(CollectionUtils.isNotEmpty(userRoles)){
            userVo.setRoles(userRoles);
            for (RoleVo roleVo : userVo.getRoles()) {
                // 添加角色
                simpleAuthorizationInfo.addRole(roleVo.getRoleCode());
                // 添加权限
                List<Permission> permissionList = roleVo.getPermissions();
                if(CollectionUtils.isNotEmpty(permissionList)){
                    for (Permission p : permissionList) {
                        simpleAuthorizationInfo.addStringPermission(p.getPermissionCode());
                    }
                }
            }
        }
        return simpleAuthorizationInfo;
    }
}
