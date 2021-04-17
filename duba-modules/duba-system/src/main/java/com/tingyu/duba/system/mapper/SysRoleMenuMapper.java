package com.tingyu.duba.system.mapper;

import java.util.List;
import com.tingyu.duba.system.domain.SysRoleMenu;

/**
 * 角色和菜单关联Mapper接口
 */
public interface SysRoleMenuMapper 
{
    /**
     * 查询角色和菜单关联
     * 
     * @param id 角色和菜单关联ID
     * @return 角色和菜单关联
     */
    public SysRoleMenu selectSysRoleMenuById(Long id);

    /**
     * 查询角色和菜单关联列表
     * 
     * @param sysRoleMenu 角色和菜单关联
     * @return 角色和菜单关联集合
     */
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu);

    /**
     * 新增角色和菜单关联
     * 
     * @param sysRoleMenu 角色和菜单关联
     * @return 结果
     */
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 修改角色和菜单关联
     * 
     * @param sysRoleMenu 角色和菜单关联
     * @return 结果
     */
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 删除角色和菜单关联
     * 
     * @param id 角色和菜单关联ID
     * @return 结果
     */
    public int deleteSysRoleMenuById(Long id);

    /**
     * 批量删除角色和菜单关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRoleMenuByIds(Long[] ids);
}
