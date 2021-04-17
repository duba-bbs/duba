package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysBarMapper;
import com.tingyu.duba.system.domain.SysBar;
import com.tingyu.duba.system.service.ISysBarService;

/**
 * 吧Service业务层处理
 */
@Service
public class SysBarServiceImpl implements ISysBarService 
{
    @Autowired
    private SysBarMapper sysBarMapper;

    /**
     * 查询吧
     * 
     * @param barId 吧ID
     * @return 吧
     */
    @Override
    public SysBar selectSysBarById(Long barId)
    {
        return sysBarMapper.selectSysBarById(barId);
    }

    /**
     * 查询吧列表
     * 
     * @param sysBar 吧
     * @return 吧
     */
    @Override
    public List<SysBar> selectSysBarList(SysBar sysBar)
    {
        return sysBarMapper.selectSysBarList(sysBar);
    }

    /**
     * 新增吧
     * 
     * @param sysBar 吧
     * @return 结果
     */
    @Override
    public int insertSysBar(SysBar sysBar)
    {
        sysBar.setCreateTime(DateUtils.getNowDate());
        return sysBarMapper.insertSysBar(sysBar);
    }

    /**
     * 修改吧
     * 
     * @param sysBar 吧
     * @return 结果
     */
    @Override
    public int updateSysBar(SysBar sysBar)
    {
        sysBar.setUpdateTime(DateUtils.getNowDate());
        return sysBarMapper.updateSysBar(sysBar);
    }

    /**
     * 批量删除吧
     * 
     * @param barIds 需要删除的吧ID
     * @return 结果
     */
    @Override
    public int deleteSysBarByIds(Long[] barIds)
    {
        return sysBarMapper.deleteSysBarByIds(barIds);
    }

    /**
     * 删除吧信息
     * 
     * @param barId 吧ID
     * @return 结果
     */
    @Override
    public int deleteSysBarById(Long barId)
    {
        return sysBarMapper.deleteSysBarById(barId);
    }
}
