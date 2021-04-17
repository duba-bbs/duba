package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysUserRelMapper;
import com.tingyu.duba.system.domain.SysUserRel;
import com.tingyu.duba.system.service.ISysUserRelService;

/**
 * 用户关系Service业务层处理
 */
@Service
public class SysUserRelServiceImpl implements ISysUserRelService 
{
    @Autowired
    private SysUserRelMapper sysUserRelMapper;

    /**
     * 查询用户关系
     * 
     * @param id 用户关系ID
     * @return 用户关系
     */
    @Override
    public SysUserRel selectSysUserRelById(Long id)
    {
        return sysUserRelMapper.selectSysUserRelById(id);
    }

    /**
     * 查询用户关系列表
     * 
     * @param sysUserRel 用户关系
     * @return 用户关系
     */
    @Override
    public List<SysUserRel> selectSysUserRelList(SysUserRel sysUserRel)
    {
        return sysUserRelMapper.selectSysUserRelList(sysUserRel);
    }

    /**
     * 新增用户关系
     * 
     * @param sysUserRel 用户关系
     * @return 结果
     */
    @Override
    public int insertSysUserRel(SysUserRel sysUserRel)
    {
        sysUserRel.setCreateTime(DateUtils.getNowDate());
        return sysUserRelMapper.insertSysUserRel(sysUserRel);
    }

    /**
     * 修改用户关系
     * 
     * @param sysUserRel 用户关系
     * @return 结果
     */
    @Override
    public int updateSysUserRel(SysUserRel sysUserRel)
    {
        sysUserRel.setUpdateTime(DateUtils.getNowDate());
        return sysUserRelMapper.updateSysUserRel(sysUserRel);
    }

    /**
     * 批量删除用户关系
     * 
     * @param ids 需要删除的用户关系ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRelByIds(Long[] ids)
    {
        return sysUserRelMapper.deleteSysUserRelByIds(ids);
    }

    /**
     * 删除用户关系信息
     * 
     * @param id 用户关系ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRelById(Long id)
    {
        return sysUserRelMapper.deleteSysUserRelById(id);
    }
}
