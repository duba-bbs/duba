package com.tingyu.duba.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysRoleBarMapper;
import com.tingyu.duba.system.domain.SysRoleBar;
import com.tingyu.duba.system.service.ISysRoleBarService;

/**
 * 角色和吧关联Service业务层处理
 */
@Service
public class SysRoleBarServiceImpl implements ISysRoleBarService 
{
    @Autowired
    private SysRoleBarMapper sysRoleBarMapper;

    /**
     * 查询角色和吧关联
     * 
     * @param id 角色和吧关联ID
     * @return 角色和吧关联
     */
    @Override
    public SysRoleBar selectSysRoleBarById(Long id)
    {
        return sysRoleBarMapper.selectSysRoleBarById(id);
    }

    /**
     * 查询角色和吧关联列表
     * 
     * @param sysRoleBar 角色和吧关联
     * @return 角色和吧关联
     */
    @Override
    public List<SysRoleBar> selectSysRoleBarList(SysRoleBar sysRoleBar)
    {
        return sysRoleBarMapper.selectSysRoleBarList(sysRoleBar);
    }

    /**
     * 新增角色和吧关联
     * 
     * @param sysRoleBar 角色和吧关联
     * @return 结果
     */
    @Override
    public int insertSysRoleBar(SysRoleBar sysRoleBar)
    {
        return sysRoleBarMapper.insertSysRoleBar(sysRoleBar);
    }

    /**
     * 修改角色和吧关联
     * 
     * @param sysRoleBar 角色和吧关联
     * @return 结果
     */
    @Override
    public int updateSysRoleBar(SysRoleBar sysRoleBar)
    {
        return sysRoleBarMapper.updateSysRoleBar(sysRoleBar);
    }

    /**
     * 批量删除角色和吧关联
     * 
     * @param ids 需要删除的角色和吧关联ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleBarByIds(Long[] ids)
    {
        return sysRoleBarMapper.deleteSysRoleBarByIds(ids);
    }

    /**
     * 删除角色和吧关联信息
     * 
     * @param id 角色和吧关联ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleBarById(Long id)
    {
        return sysRoleBarMapper.deleteSysRoleBarById(id);
    }
}
