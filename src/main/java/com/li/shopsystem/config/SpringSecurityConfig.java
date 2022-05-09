package com.li.shopsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @ClassName SpringSecurityConfig
 * @Author ：Li
 * @Date ：2022/5/8 20:18
 * @Description：
 * @Version: 1.0
 */

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery("select name,pwd from user where name=?").
                authoritiesByUsernameQuery("select name,role from role where name=?").
                passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().
                antMatchers("/").permitAll()
                .antMatchers("/tosignup").permitAll()
                .antMatchers("/tologin").permitAll()
                .antMatchers("/getCode").permitAll()
                .antMatchers("/user/**").hasRole("add");



        http.formLogin().loginPage("/");

    }

}
