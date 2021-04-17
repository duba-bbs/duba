package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysRoleBar;

/**
 * 角色和吧关联Service接口
 */
public interface ISysRoleBarService 
{
    /**
     * 查询角色和吧关联
     * 
     * @param id 角色和吧关联ID
     * @return 角色和吧关联
     */
    public SysRoleBar selectSysRoleBarById(Long id);

    /**
     * 查询角色和吧关联列表
     * 
     * @param sysRoleBar 角色和吧关联
     * @return 角色和吧关联集合
     */
    public List<SysRoleBar> selectSysRoleBarList(SysRoleBar sysRoleBar);

    /**
     * 新增角色和吧关联
     * 
     * @param sysRoleBar 角色和吧关联
     * @return 结果
     */
    public int insertSysRoleBar(SysRoleBar sysRoleBar);

    /**
     * 修改角色和吧关联
     * 
     * @param sysRoleBar 角色和吧关联
     * @return 结果
     */
    public int updateSysRoleBar(SysRoleBar sysRoleBar);

    /**
     * 批量删除角色和吧关联
     * 
     * @param ids 需要删除的角色和吧关联ID
     * @return 结果
     */
    public int deleteSysRoleBarByIds(Long[] ids);

    /**
     * 删除角色和吧关联信息
     * 
     * @param id 角色和吧关联ID
     * @return 结果
     */
    public int deleteSysRoleBarById(Long id);
}
