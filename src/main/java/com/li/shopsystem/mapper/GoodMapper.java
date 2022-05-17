package com.li.shopsystem.mapper;

import com.li.shopsystem.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Li
 * 商品类Mapper
 */
@Mapper
@Repository
public interface GoodMapper {

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
    Good selectGoodByID(String gid,@Param("sid")Long sid);

    /**
     * 根据商品名和店铺ID进行模糊查询,返回商品集合
     * @param name 商品名称
     * @param sid 店铺ID
     * @return List<Good> 商品模糊查询结果集
     */
    List<Good> listSelectGoodByName(String name,@Param("sid") Long sid);

    /**
     * 分页查询店铺id位sid的商品
     * @param sid 店铺id
     * @param page 第几页
     * @param limit 每页数据
     * @return
     */
    List<Good> listSelecAllGoods(Long sid,int page,int limit);
}
