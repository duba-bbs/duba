package com.tingyu.duba.system.service;

import java.util.Set;

/**
 * 菜单权限Service接口
 */
public interface ISysMenuService {

    public Set<String> selectSysMenuPermsByUserId(Long menuId);

}
