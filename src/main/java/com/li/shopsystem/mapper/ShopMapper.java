package com.li.shopsystem.mapper;

import com.li.shopsystem.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Li
 * 店铺类Mapper
 */
@Mapper
@Repository
public interface ShopMapper {
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
