package com.li.shopsystem.service;


import com.li.shopsystem.pojo.UserRole;
/**
 * @author Li
 * 带权限的用户类Service
 */
public interface UserRoleService {
    /**
     * 根据店铺ID和个人ID获取当前用户权限
     * @param uid 用户ID
     * @param sid 店铺ID
     * @return 带权限的用户类
     */
    UserRole selectUserRole(Long uid, Long sid);
}
