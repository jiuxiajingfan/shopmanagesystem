package com.li.shopsystem.service;

import com.li.shopsystem.pojo.Good;

import java.util.List;

/**
 * @author Li
 * 商品类Service
 */
public interface GoodService {

    /**
     * 新建商品，并返回执行结果
     * @param good 商品类
     * @return int 执行结果
     */
    int insertGood(Good good);

    /**
     * 修改商品，并返回执行结果
     * @param good 商品类
     * @return int 执行结果
     */
    int updateGood(Good good);

    /**
     * 删除商品，并返回结果
     * @param id 商品类ID
     * @return  int 执行结果
     */
    int deleteGood(Long id);

    /**
     * 根据店铺ID和商品条形码搜索商品，返回商品对象
     * @param gid 商品条形码
     * @param sid 店铺ID
     * @return Good 商品对象
     */
    Good selectGoodByID(String gid,Long sid);

    /**
     * 根据商品名和店铺ID进行模糊查询,返回商品集合
     * @param name 商品名称
     * @param sid 店铺ID
     * @return List<Good> 商品模糊查询结果集
     */
    List<Good> listSelectGoodByName(String name, Long sid);
}
