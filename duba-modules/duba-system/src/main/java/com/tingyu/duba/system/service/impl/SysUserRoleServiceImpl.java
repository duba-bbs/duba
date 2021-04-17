package com.tingyu.duba.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysUserRoleMapper;
import com.tingyu.duba.system.domain.SysUserRole;
import com.tingyu.duba.system.service.ISysUserRoleService;

/**
 * 用户和角色关联Service业务层处理
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService 
{
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询用户和角色关联
     * 
     * @param id 用户和角色关联ID
     * @return 用户和角色关联
     */
    @Override
    public SysUserRole selectSysUserRoleById(Long id)
    {
        return sysUserRoleMapper.selectSysUserRoleById(id);
    }

    /**
     * 查询用户和角色关联列表
     * 
     * @param sysUserRole 用户和角色关联
     * @return 用户和角色关联
     */
    @Override
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole)
    {
        return sysUserRoleMapper.selectSysUserRoleList(sysUserRole);
    }

    /**
     * 新增用户和角色关联
     * 
     * @param sysUserRole 用户和角色关联
     * @return 结果
     */
    @Override
    public int insertSysUserRole(SysUserRole sysUserRole)
    {
        return sysUserRoleMapper.insertSysUserRole(sysUserRole);
    }

    /**
     * 修改用户和角色关联
     * 
     * @param sysUserRole 用户和角色关联
     * @return 结果
     */
    @Override
    public int updateSysUserRole(SysUserRole sysUserRole)
    {
        return sysUserRoleMapper.updateSysUserRole(sysUserRole);
    }

    /**
     * 批量删除用户和角色关联
     * 
     * @param ids 需要删除的用户和角色关联ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRoleByIds(Long[] ids)
    {
        return sysUserRoleMapper.deleteSysUserRoleByIds(ids);
    }

    /**
     * 删除用户和角色关联信息
     * 
     * @param id 用户和角色关联ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRoleById(Long id)
    {
        return sysUserRoleMapper.deleteSysUserRoleById(id);
    }
}
