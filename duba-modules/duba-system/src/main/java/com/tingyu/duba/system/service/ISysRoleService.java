package com.tingyu.duba.system.service;

import java.util.Set;

/**
 * 用户信息Service接口
 */
public interface ISysRoleService {
    public Set<String> selectSysRolePermissionByUserId(Long userId);
}
