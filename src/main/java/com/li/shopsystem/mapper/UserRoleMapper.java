package com.li.shopsystem.mapper;

import com.li.shopsystem.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Li
 * 带权限的用户类Mapper
 */
@Mapper
@Repository
public interface UserRoleMapper {
    /**
     * 根据店铺ID和个人ID获取当前用户权限
     * @param uid 用户ID
     * @param sid 店铺ID
     * @return 带权限的用户类
     */
    UserRole selectUserRole(Long uid,Long sid);
}
