package com.tingyu.duba.system.service;

import java.util.List;

import com.tingyu.duba.system.api.domain.SysUser;

/**
 * 用户信息Service接口
 */
public interface ISysUserService {

    public SysUser selectSysUserByUsername(String username);

}
