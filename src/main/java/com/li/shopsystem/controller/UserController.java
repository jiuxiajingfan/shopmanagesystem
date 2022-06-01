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
import reactor.core.publisher.Mono;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;
import java.sql.Array;
import java.util.*;


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
    public GoodsMessage allGoods(@PathVariable("id") Long id, int page, int limit,String value) {
        if (Objects.isNull(value)) {
            return goodService.selectAllGoods(id, page, limit);
        } else {
            System.out.println(value.hashCode());
            if(value.hashCode()==0) {
                return goodService.selectAllGoods(id, page, limit);
            }else{
            return goodService.selectGoodsByGidOrName(value, id);
            }
        }
    }

    @RequestMapping("/myshop/{id}/goods/updategood/{gid}")
    public String updateGood(@PathVariable("id") Long id, @PathVariable("gid") Long gid, Model model){
        int i = goodService.updataGoodPage(id, gid, model);
        System.out.println(id);
        return "updateGood";
    }

    @RequestMapping("/myshop/{id}/goods/addgood")
    public String addGood(@PathVariable("id") Long id){
        return "addGood";
    }

    @RequestMapping("/myshop/{id}/temporary")
    public String temporaryGood(@PathVariable("id") Long id){
        return "temporaryFood";
    }

    @ResponseBody
    @RequestMapping("/myshop/{id}/totemporary")
    public GoodsMessage add(@PathVariable("id") Long sid){
        return goodService.toTemporary(sid,30);
    }
    @RequestMapping("/tocashier/{sid}")
    public String Cashier(@PathVariable("sid") Long sid){
        return "Cashier";
    }


}
