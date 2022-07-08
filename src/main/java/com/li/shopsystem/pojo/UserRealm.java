package com.li.shopsystem.pojo;

import com.li.shopsystem.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @ClassName UserRealm
 * @Author ：Li
 * @Date ：2022/5/12 20:27
 * @Description：
 * @Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("souquan=====>>>>.");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
////        Subject subject = SecurityUtils.getSubject();
////        User user = (User) subject.getPrincipals();
////
////        //设置用户权限
////        info.addStringPermission(" ");



        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("renzheng============>");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        User user = userService.userLogin(userToken.getUsername());
        System.out.println(user);
        if(Objects.isNull(user)){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
