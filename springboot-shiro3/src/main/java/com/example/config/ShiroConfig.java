package com.example.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.example.cache.RedisCacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-13 00:46
 * @version: 1.0
 */

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean 3.
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        System.out.println("======ShiroConfig-->ShiroFilterFactoryBean=========");
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置管理器
        /**
         * anon：无需认证即可访问
         * authc：必须认证才能访问
         * user：必须拥有 记住我 功能
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        //拦截
        Map<String, String> filter = new LinkedHashMap();
        filter.put("/register","anon");
        filter.put("/login","anon");
        filter.put("/logout","anon");

        //授权 必须是user:add权限的才能访问
        filter.put("/user/add", "perms[user:add]");
        //授权 必须是user:add权限的才能访问
        filter.put("/user/update", "perms[user:update]");
        filter.put("/user/*", "authc");  //通配符放在最后

        filterFactoryBean.setFilterChainDefinitionMap(filter);

        //设置登录的请求
        filterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权请求页面
        filterFactoryBean.setUnauthorizedUrl("/unAuthor");

        return filterFactoryBean;
    }

    //DefaultWebSecurityManager 2.
    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm){
        System.out.println("======ShiroConfig-->WebSecurityManager=========");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm类，自定义
    @Bean
    public UserRealm userRealm(@Qualifier("ehCacheManager") EhCacheManager ehCacheManager){
        System.out.println("======ShiroConfig-->userRealm=========");
        final UserRealm userRealm = new UserRealm();

        //可以单独设置加salt
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);

        userRealm.setCredentialsMatcher(credentialsMatcher);
        //开启缓存
//        userRealm.setCacheManager(ehCacheManager);
        userRealm.setCacheManager(new RedisCacheManager());
        userRealm.setCachingEnabled(true);//开启全局缓存
        userRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
        userRealm.setAuthenticationCacheName("authenticationCache");
        userRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
        userRealm.setAuthorizationCacheName("authorizationCache");


        return userRealm;
    }

    //整合shiroDialect 用于thymeleaf和shiro标签配合使用
    @Bean
    public ShiroDialect shiroDialect(){
        System.out.println("======ShiroConfig-->shiroDialect=========");
        return new ShiroDialect();
    }

    @Bean
    public EhCacheManager ehCacheManager(){
        System.out.println("======ShiroConfig-->ehCacheManager=========");
        final EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
    }

}
