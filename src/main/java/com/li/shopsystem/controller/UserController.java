package com.li.shopsystem.controller;


import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.pojo.GoodsMessage;
import com.li.shopsystem.pojo.Shop;
import com.li.shopsystem.service.GoodService;
import com.li.shopsystem.service.impl.GoodServiceImpl;
import com.li.shopsystem.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.Subject;
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

    @Autowired
    private GoodServiceImpl goodService;



    @RequestMapping("/selectshop")
    public String selectShop(Model model){
        userService.selectShop(model);
        return "selectshop";
    }


    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/myshop/{id}")
    public String myshop(@PathVariable("id") Long id){
        return "myshop";
    }

    @RequestMapping("/myshop/{id}/goods")
    public String goods(@PathVariable("id") Long id){
        return  "goods";
    }

    @ResponseBody
    @RequestMapping("/myshop/{id}/goods/allgoods")
    public GoodsMessage allGoods(@PathVariable("id") Long id, int page, int limit){
        System.out.println(page);
        System.out.println(limit);
        return goodService.selectAllGoods(id,page,limit);
    }

}
