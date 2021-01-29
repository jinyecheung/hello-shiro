package com.example.hello.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * http://shiro.apache.org/java-authentication-guide.html
 */
@Configuration
public class ShiroConfig {

    // 将自己的验证方式加入容器
    @Bean
    public MyAuthorizingRealm myShiroRealm() {
        MyAuthorizingRealm myShiroRealm = new MyAuthorizingRealm();
        return myShiroRealm;
    }

    // 权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    // 拦截枚举 org.apache.shiro.web.filter.mgt.DefaultFilter
    // Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new HashMap<String, String>();
        // 登出
        filterMap.put("/logout", "logout");
        // swagger
        filterMap.put("/swagger**/**", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/v2/**", "anon");
        //
        //filterMap.put("/user/**", "anon");
        //filterMap.put("/index/**", "anon");
        filterMap.put("/login/loginAction","anon");
        //filterMap.put("/errorPage","anon");
        // 对所有用户认证
        filterMap.put("/**", "authc");
        // 登录
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 首页
        shiroFilterFactoryBean.setSuccessUrl("/login/index");
        // 错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/sys/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 开启代码权限注解支持,需要两个Bean分别为：
     * AuthorizationAttributeSourceAdvisor 和 DefaultAdvisorAutoProxyCreator
     * 注解校验权限角色、权限需要这两个Bean
     * 加入注解的使用，不加入这个注解不生效
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 解决权限注解不生效问题
     * @return
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    /** html界面支持shiro标签库
     * <html lang="en" xmlns:th="http://www.thymeleaf.org"
     *       xmlns:shiro="http://www.pollix.at/thymeleaf/shiro">
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
