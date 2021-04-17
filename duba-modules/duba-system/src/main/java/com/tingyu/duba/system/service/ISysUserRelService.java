package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysUserRel;

/**
 * 用户关系Service接口
 */
public interface ISysUserRelService 
{
    /**
     * 查询用户关系
     * 
     * @param id 用户关系ID
     * @return 用户关系
     */
    public SysUserRel selectSysUserRelById(Long id);

    /**
     * 查询用户关系列表
     * 
     * @param sysUserRel 用户关系
     * @return 用户关系集合
     */
    public List<SysUserRel> selectSysUserRelList(SysUserRel sysUserRel);

    /**
     * 新增用户关系
     * 
     * @param sysUserRel 用户关系
     * @return 结果
     */
    public int insertSysUserRel(SysUserRel sysUserRel);

    /**
     * 修改用户关系
     * 
     * @param sysUserRel 用户关系
     * @return 结果
     */
    public int updateSysUserRel(SysUserRel sysUserRel);

    /**
     * 批量删除用户关系
     * 
     * @param ids 需要删除的用户关系ID
     * @return 结果
     */
    public int deleteSysUserRelByIds(Long[] ids);

    /**
     * 删除用户关系信息
     * 
     * @param id 用户关系ID
     * @return 结果
     */
    public int deleteSysUserRelById(Long id);
}
