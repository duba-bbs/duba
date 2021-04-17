package com.tingyu.duba.system.service;

import java.util.Set;

public interface ISysPermissionService {
    /**
     * 获取角色数据权限
     * 
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(Long userId, String userType);

    /**
     * 获取菜单数据权限
     * 
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(Long userId, String userType);
}
