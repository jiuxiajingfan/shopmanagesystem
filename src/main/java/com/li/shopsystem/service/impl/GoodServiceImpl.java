package com.li.shopsystem.service.impl;

import com.alibaba.fastjson2.JSON;
import com.li.shopsystem.mapper.GoodMapper;
import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.pojo.GoodsMessage;
import com.li.shopsystem.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    public Good selectGoodByID(String gid, Long sid) {
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
