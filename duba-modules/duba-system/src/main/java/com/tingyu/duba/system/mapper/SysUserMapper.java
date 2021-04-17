package com.tingyu.duba.system.mapper;

import com.tingyu.duba.system.api.domain.SysUser;

/**
 * 用户信息Mapper接口
 */
public interface SysUserMapper {

    public SysUser selectSysUserByUsername(String username);

}
