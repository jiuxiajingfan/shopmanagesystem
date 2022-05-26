package com.li.shopsystem.service;

import com.li.shopsystem.pojo.Shop;

/**
 * @author Li
 * 店铺类Service
 */
public interface ShopService {
    /**
     * 新增店铺，返回执行结果
     * @param shop 店铺类
     * @return int 执行结果
     */
    int insertShop(Shop shop);


    /**
     * 更新店铺信息，返回执行结果
     * @param shop 店铺类
     * @return int 执行结果
     */
    int updateShop(Shop shop);

    /**
     * 删除店铺，返回执行结果
     * @param id  店铺类ID
     * @return int 执行结果
     */
    int deleteShop(Long id);

}
