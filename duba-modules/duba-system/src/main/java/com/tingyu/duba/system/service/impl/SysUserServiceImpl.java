package com.tingyu.duba.system.service.impl;

import com.tingyu.duba.system.api.domain.SysUser;
import com.tingyu.duba.system.mapper.SysUserMapper;
import com.tingyu.duba.system.service.ISysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息Service业务层处理
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectSysUserByUsername(String username) {
        return sysUserMapper.selectSysUserByUsername(username);
    }
}
