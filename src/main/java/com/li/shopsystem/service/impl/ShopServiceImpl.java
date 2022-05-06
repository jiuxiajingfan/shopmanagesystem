package com.li.shopsystem.service.impl;

import com.li.shopsystem.mapper.ShopMapper;
import com.li.shopsystem.pojo.Shop;
import com.li.shopsystem.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Li
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;
    @Override
    public int insertShop(Shop shop) {
        return shopMapper.insertShop(shop);
    }

    @Override
    public int updateShop(Shop shop) {
        return shopMapper.updateShop(shop);
    }

    @Override
    public int deleteShop(Long id) {
        return shopMapper.deleteShop(id);
    }
}
