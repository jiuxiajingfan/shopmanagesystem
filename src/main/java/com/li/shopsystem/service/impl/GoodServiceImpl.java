package com.li.shopsystem.service.impl;

import com.alibaba.fastjson2.JSON;
import com.li.shopsystem.mapper.GoodMapper;
import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.pojo.GoodsMessage;
import com.li.shopsystem.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Li
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    public GoodsMessage selectAllGoods(Long sid,int page,int limit){
        GoodsMessage msg = new GoodsMessage();
        List<Good> goods = this.listSelecAllGoods(sid,page,limit);
        if(Objects.isNull(goods)){
            msg.setCode(-1);
            msg.setCount(0);
            msg.setMsg("没有数据啦！");
            msg.setData(null);
        }else{
            msg.setCode(0);
            msg.setCount(this.numberGoods(sid));
            msg.setMsg("查询成功");
            msg.setData(goods);
        }
        return msg;
    }

    public GoodsMessage selectGoodsByGidOrName(String gid,Long id){
        GoodsMessage msg = new GoodsMessage();
        List<Good> goods = this.selectGoodByID(gid, id);
        if(Objects.isNull(goods)){
            msg.setCode(-1);
            msg.setCount(0);
            msg.setMsg("没有数据啦！");
            msg.setData(null);
        }else{
            msg.setCode(0);
            msg.setCount(1);
            msg.setMsg("查询成功");
            msg.setData(goods);
        }
        return msg;
    }

    public int updataGoodPage(Long id, Long gid, Model model){
        Good good = this.selectGoodByGid(id, gid);

        if(Objects.isNull(good)){
            return -1;
        }else{
            Object o = JSON.toJSON(good);
            model.addAttribute("good",o);
        }
        return 1;
    }

    public int toUpdateGood(Long id, Long sid, String gid, String goodName, int in_price, int out_price, String gmt_make, String gmt_overdue, Long number){
        Good good = new Good();
        good.setId(id);
        good.setGid(gid);
        good.setIn_price(in_price);
        good.setOut_price(out_price);
        good.setProfit(out_price-in_price);
        good.setNumber(number);
        good.setName(goodName);
        good.setGmt_create(new Date(System.currentTimeMillis()));
        Date date = null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(gmt_make);
            good.setGmt_make(date);
            date = formatter.parse(gmt_overdue);
            good.setGmt_overdue(date);
            System.out.println(good);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        int result = this.updateGood(good);
        return result;
    }
    @Override
    public int insertGood(Good good) {
        return goodMapper.insertGood(good);
    }

    @Override
    public int updateGood(Good good) {
        return goodMapper.updateGood(good);
    }

    @Override
    public int deleteGood(Long id) {
        return goodMapper.deleteGood(id);
    }

    @Override
    public List<Good> selectGoodByID(String gid, Long sid) {
        return goodMapper.selectGoodByID(gid,sid);
    }

    @Override
    public List<Good> listSelectGoodByName(String name, Long sid) {
        return goodMapper.listSelectGoodByName(name,sid);
    }

    @Override
    public List<Good> listSelecAllGoods(Long sid,int page,int limit) {
        page = (page-1)*limit;
        return goodMapper.listSelecAllGoods(sid,page,limit);
    }

    @Override
    public int numberGoods(Long sid) {
        return goodMapper.numberGoods(sid);
    }

    @Override
    public Good selectGoodByGid(Long id, Long gid) {
        return goodMapper.selectGoodByGid(id,gid);
    }


}
