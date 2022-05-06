package com.li.shopsystem.controller;


import com.li.shopsystem.pojo.Shop;
import com.li.shopsystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Li
 * 用户Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/tologin")
    @ResponseBody
    public int toLogin(String userName, String passWord, HttpSession session){
        return userService.userToLogin(userName,passWord,session);
    }

    @RequestMapping("/getCode")
    @ResponseBody
    public int getCode(String email){
       return userService.getCode(email);
    }

    @RequestMapping("/tosignup")
    @ResponseBody
    public int toSignUp(String userName,String passWord,String email,String code){
        return userService.toSignUp(userName,passWord,email,code);
    }

    @RequestMapping("/selectshop")
    public String selectShop(Model model,HttpSession session){
        Long userID =(Long)session.getAttribute("UserID");
        List<Shop> shops = userService.listSelectShopByUID(userID);
        System.out.println(shops);
        model.addAttribute("usersb", Arrays.asList("123","321","561"));
        model.addAttribute("shops",shops);
        return "selectshop";
    }



}
