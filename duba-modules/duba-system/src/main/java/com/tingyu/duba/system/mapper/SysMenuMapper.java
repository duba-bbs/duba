package com.tingyu.duba.system.mapper;

import java.util.List;
import com.tingyu.duba.system.domain.SysMenu;

/**
 * 菜单权限Mapper接口
 */
public interface SysMenuMapper {
    public List<String> selectSysMenuPermsByUserId(Long userId);
}
