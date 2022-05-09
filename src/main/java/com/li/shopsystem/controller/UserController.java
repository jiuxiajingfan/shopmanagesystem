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



    @RequestMapping("/selectshop")
    public String selectShop(Model model,HttpSession session){
        Long userID =(Long)session.getAttribute("UserID");
        List<Shop> shops = userService.listSelectShopByUID(userID);
        System.out.println(shops);
        model.addAttribute("shops",shops);
        return "selectshop";
    }


    @RequestMapping("/home")
    public String home(){
        return "home";
    }



}
