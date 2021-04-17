package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysUserRole;

/**
 * 用户和角色关联Service接口
 */
public interface ISysUserRoleService 
{
    /**
     * 查询用户和角色关联
     * 
     * @param id 用户和角色关联ID
     * @return 用户和角色关联
     */
    public SysUserRole selectSysUserRoleById(Long id);

    /**
     * 查询用户和角色关联列表
     * 
     * @param sysUserRole 用户和角色关联
     * @return 用户和角色关联集合
     */
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole);

    /**
     * 新增用户和角色关联
     * 
     * @param sysUserRole 用户和角色关联
     * @return 结果
     */
    public int insertSysUserRole(SysUserRole sysUserRole);

    /**
     * 修改用户和角色关联
     * 
     * @param sysUserRole 用户和角色关联
     * @return 结果
     */
    public int updateSysUserRole(SysUserRole sysUserRole);

    /**
     * 批量删除用户和角色关联
     * 
     * @param ids 需要删除的用户和角色关联ID
     * @return 结果
     */
    public int deleteSysUserRoleByIds(Long[] ids);

    /**
     * 删除用户和角色关联信息
     * 
     * @param id 用户和角色关联ID
     * @return 结果
     */
    public int deleteSysUserRoleById(Long id);
}
