package com.li.shopsystem.controller;


import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.service.impl.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Li
 */
@Controller
@RestController
@RequestMapping("Good")
public class GoodController {
    @Autowired
    private GoodServiceImpl goodService;

    @RequestMapping("/select/{name}/{sid}")
    public List<Good> listSelectGoodByName(@PathVariable("name")String name,@PathVariable("sid") Long sid)
    {
        List<Good> goods = goodService.listSelectGoodByName(name, sid);
        return goods;
    }
}
