package com.li.shopsystem.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.li.shopsystem.pojo.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String,String> filter = new LinkedHashMap<>();
        filter.put("/user/*","authc");
        filter.put("/user/*","perms[user:add]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filter);
        shiroFilterFactoryBean.setSuccessUrl("/");
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
