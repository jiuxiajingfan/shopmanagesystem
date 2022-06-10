package com.li.shopsystem.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.service.impl.GoodServiceImpl;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Li
 */
@Controller
@RestController
@RequestMapping("good")
public class GoodController {
    @Autowired
    private GoodServiceImpl goodService;

    @RequestMapping("/select/{name}/{sid}")
    public List<Good> listSelectGoodByName(@PathVariable("name")String name,@PathVariable("sid") Long sid)
    {
        List<Good> goods = goodService.selectGoodByID(name, sid);

        return goods;
    }

    @RequestMapping("/update/{id}/{sid}")
    public int update(@PathVariable("id") Long id, @PathVariable("sid") Long sid, String goodID, String goodName, double in_price, double out_price, String gmt_make, String gmt_overdue, Long number){
        return  goodService.toUpdateGood(id,sid,goodID,goodName,in_price,out_price,gmt_make,gmt_overdue,number);
    }

    @RequestMapping("/delete/{sid}")
    public int delete(@PathVariable("sid")Long id){
        return goodService.deleteGood(id);
    }

    @RequestMapping("/add/{sid}")
    public int add(@PathVariable("sid") Long sid, String gid,String goodName, double in_price, double out_price, String gmt_make, String gmt_overdue, Long number){
        return goodService.toAdd(sid,gid,goodName,in_price,out_price,gmt_make,gmt_overdue,number);
    }

    @RequestMapping("record/{sid}")
    public int record(@PathVariable("sid")Long sid, String data){
        return goodService.GoodSale(sid,data);
    }


}
