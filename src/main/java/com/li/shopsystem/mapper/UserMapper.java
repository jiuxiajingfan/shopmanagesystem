package com.li.shopsystem.mapper;

import com.li.shopsystem.pojo.Shop;
import com.li.shopsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Li
 * UserMapper
 */

@Mapper
@Repository
public interface UserMapper {
    /**
     * 新建用户，返回执行结果
     * @param user 用户类
     * @return int 执行结果
     */
    int insertUser(User user);

    /**
     * 修改用户，返回执行结果
     * @param user 用户类
     * @return int 执行结果
     */
    int updateUser(User user);

    /**
     * 删除用户，返回执行结果
     * @param uid 用户id
     * @return int 执行结果
     */
    int deleteUser(Long uid);

    /**
     * 根据当前用户ID获取所相关的店铺
     * @param uid 用户ID
     * @return 店铺实体类集合
     */
    List<Shop> listSelectShopByUID(Long uid);


    /**
     * 用户登录类
     * @param userName 账户名
     * @return  用户实体类
     */
    User userLogin(@PathVariable("userName") String userName);


}
