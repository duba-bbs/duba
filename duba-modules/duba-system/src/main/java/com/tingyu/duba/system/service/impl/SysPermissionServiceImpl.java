package com.tingyu.duba.system.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.tingyu.duba.common.core.enums.UserType;
import com.tingyu.duba.system.api.domain.SysUser;
import com.tingyu.duba.system.service.ISysMenuService;
import com.tingyu.duba.system.service.ISysPermissionService;
import com.tingyu.duba.system.service.ISysRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysMenuService menuService;

    /**
     * 获取角色数据权限
     * 
     * @return 角色权限信息
     */
    @Override
    public Set<String> getRolePermission(Long userId, String userType) {
        Set<String> roles = new HashSet<String>();
        // 管理员拥有所有权限
        if (UserType.ADMIN.getCode().equals(userType)) {
            roles.add("admin");
        } else {
            roles.addAll(roleService.selectSysRolePermissionByUserId(userId));
        }
        return roles;
    }

    /**
     * 获取菜单数据权限
     * 
     * @return 菜单权限信息
     */
    @Override
    public Set<String> getMenuPermission(Long userId, String userType) {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (UserType.ADMIN.getCode().equals(userType)) {
            perms.add("*:*:*");
        } else {
            perms.addAll(menuService.selectSysMenuPermsByUserId(userId));
        }
        return perms;
    }
}
