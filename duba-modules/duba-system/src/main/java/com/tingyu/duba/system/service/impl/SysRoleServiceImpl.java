package com.tingyu.duba.system.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tingyu.duba.common.core.utils.StringUtils;
import com.tingyu.duba.system.domain.SysRole;
import com.tingyu.duba.system.mapper.SysRoleMapper;
import com.tingyu.duba.system.service.ISysRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息Service业务层处理
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> selectSysRolePermissionByUserId(Long userId) {
        List<SysRole> perms = sysRoleMapper.selectSysRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }
}
