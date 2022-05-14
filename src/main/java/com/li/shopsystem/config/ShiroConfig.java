package com.li.shopsystem.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.li.shopsystem.pojo.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Author ：Li
 * @Date ：2022/5/12 20:13
 * @Description：
 * @Version: 1.0
 */

@Configuration
public class ShiroConfig {


    /**
     * Shiro内置过滤器，可以实现权限相关的拦截器
     *    常用的过滤器：
     *       anon: 无需认证（登录）可以访问
     *       authc: 必须认证才可以访问
     *       user: 如果使用rememberMe的功能可以直接访问
     *       perms： 该资源必须得到资源权限才可以访问
     *       role: 该资源必须得到角色权限才可以访问
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String,String> filter = new LinkedHashMap<>();
//        filter.put("/user/selectshop","perms[user:update]");
        filter.put("/user/**","authc");
        filter.put("/*","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filter);

        //成功跳转页
        shiroFilterFactoryBean.setSuccessUrl("/user/home");
        //默认登录页
        shiroFilterFactoryBean.setLoginUrl("/");
        //无权限提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/401");
        return shiroFilterFactoryBean;

    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合Thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
