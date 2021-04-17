package com.tingyu.duba.system.mapper;

import java.util.List;
import com.tingyu.duba.system.domain.SysRole;

/**
 * 用户信息Mapper接口
 */
public interface SysRoleMapper {

    public List<SysRole> selectSysRolePermissionByUserId(Long roleId);

}
