package com.li.shopsystem.service.impl;

import com.li.shopsystem.mapper.GoodMapper;
import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.pojo.GoodsMessage;
import com.li.shopsystem.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            msg.setCount(goods.size());
            msg.setMsg("查询成功");
            msg.setData(goods);
        }
        return msg;
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



}
