package com.li.shopsystem.service.impl;

import com.li.shopsystem.mapper.UserRoleMapper;
import com.li.shopsystem.pojo.UserRole;
import com.li.shopsystem.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Li
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public UserRole selectUserRole(Long uid, Long sid) {
        return userRoleMapper.selectUserRole(uid, sid);
    }
}
