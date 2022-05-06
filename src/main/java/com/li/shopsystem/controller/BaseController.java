package com.li.shopsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共页Controller
 * @author Li
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }


}
