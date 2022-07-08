package com.li.shopsystem.mapper;

import com.li.shopsystem.pojo.Good;
import com.li.shopsystem.pojo.record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
     * @return int 执行结果`    123
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
    List<Good> selectGoodByID(String gid,@Param("sid")Long sid);

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

    /**
     * 获取某个店铺的商品总数量
     * @param sid 店铺ID
     * @return
     */
    int numberGoods(Long sid);

    /**
     * 根据商品ID和店铺ID搜索商品
     * @param id
     * @param gid
     * @return
     */
    Good selectGoodByGid(Long id,Long gid);

    /**
     * 查询店铺即将过期商品
     * @param id 店铺id
     * @param day   天数
     * @return
     */
    List<Good> seletctTemporary(Long id,int day);

    /**
     * 添加商品交易记录
     * @param sid 店铺ID
     * @param money 交易金额
     * @param no 订单号
     * @return 订单号ID
     */
    int addrecord(Long sid,double money,String no);

    /**
     * 添加商品交易信息
     * @param gid 商品ID
     * @param name  商品名
     * @param number   商品交易数量
     * @param price     商品单价
     * @param sum   商品总价
     * @param no    订单号
     * @return
     */
    int addgoodrecord(String gid,String name,int number,double price,double sum,String no);

    /**
     * 查询时间区间内的店铺交易信息
     * @param sid 店铺id
     * @param dateFrom 起始时间
     * @param dateTo  结束时间
     * @return  交易类
     */
    List<record> findRecord(Long sid, Date dateFrom, Date dateTo);
}
