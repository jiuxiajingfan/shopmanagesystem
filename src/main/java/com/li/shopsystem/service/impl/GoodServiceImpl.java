package com.li.shopsystem.service.impl;

import com.li.shopsystem.mapper.GoodMapper;
import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

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
}
