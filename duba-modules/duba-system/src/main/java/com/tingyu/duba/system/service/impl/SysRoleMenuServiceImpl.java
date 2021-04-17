package com.tingyu.duba.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysRoleMenuMapper;
import com.tingyu.duba.system.domain.SysRoleMenu;
import com.tingyu.duba.system.service.ISysRoleMenuService;

/**
 * 角色和菜单关联Service业务层处理
 */
@Service
public class SysRoleMenuServiceImpl implements ISysRoleMenuService 
{
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 查询角色和菜单关联
     * 
     * @param id 角色和菜单关联ID
     * @return 角色和菜单关联
     */
    @Override
    public SysRoleMenu selectSysRoleMenuById(Long id)
    {
        return sysRoleMenuMapper.selectSysRoleMenuById(id);
    }

    /**
     * 查询角色和菜单关联列表
     * 
     * @param sysRoleMenu 角色和菜单关联
     * @return 角色和菜单关联
     */
    @Override
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.selectSysRoleMenuList(sysRoleMenu);
    }

    /**
     * 新增角色和菜单关联
     * 
     * @param sysRoleMenu 角色和菜单关联
     * @return 结果
     */
    @Override
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.insertSysRoleMenu(sysRoleMenu);
    }

    /**
     * 修改角色和菜单关联
     * 
     * @param sysRoleMenu 角色和菜单关联
     * @return 结果
     */
    @Override
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu)
    {
        return sysRoleMenuMapper.updateSysRoleMenu(sysRoleMenu);
    }

    /**
     * 批量删除角色和菜单关联
     * 
     * @param ids 需要删除的角色和菜单关联ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleMenuByIds(Long[] ids)
    {
        return sysRoleMenuMapper.deleteSysRoleMenuByIds(ids);
    }

    /**
     * 删除角色和菜单关联信息
     * 
     * @param id 角色和菜单关联ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleMenuById(Long id)
    {
        return sysRoleMenuMapper.deleteSysRoleMenuById(id);
    }
}
