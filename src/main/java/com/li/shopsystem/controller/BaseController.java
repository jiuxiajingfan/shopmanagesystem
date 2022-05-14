package com.li.shopsystem.controller;


import com.li.shopsystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 公共页Controller
 * @author Li
 */
@Controller
public class BaseController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping({"/index","/"})
    public String index(){
        return "login";
    }


    @RequestMapping("/getCode")
    @ResponseBody
    public int getCode(String email){
        return userService.getCode(email);
    }

    @RequestMapping("/tologin")
    @ResponseBody
    public int toLogin(String userName, String passWord, HttpSession session){
        return userService.userToLogin(userName,passWord);
    }

    @RequestMapping("/tosignup")
    @ResponseBody
    public int toSignUp(String userName,String passWord,String email,String code){
        return userService.toSignUp(userName,passWord,email,code);
    }


    @RequestMapping({"/401"})
    public String error401(){
        return "error/401";
    }



}
