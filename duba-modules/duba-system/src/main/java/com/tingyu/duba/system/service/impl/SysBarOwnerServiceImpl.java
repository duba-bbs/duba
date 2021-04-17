package com.tingyu.duba.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysBarOwnerMapper;
import com.tingyu.duba.system.domain.SysBarOwner;
import com.tingyu.duba.system.service.ISysBarOwnerService;

/**
 * 吧主Service业务层处理
 */
@Service
public class SysBarOwnerServiceImpl implements ISysBarOwnerService 
{
    @Autowired
    private SysBarOwnerMapper sysBarOwnerMapper;

    /**
     * 查询吧主
     * 
     * @param id 吧主ID
     * @return 吧主
     */
    @Override
    public SysBarOwner selectSysBarOwnerById(Long id)
    {
        return sysBarOwnerMapper.selectSysBarOwnerById(id);
    }

    /**
     * 查询吧主列表
     * 
     * @param sysBarOwner 吧主
     * @return 吧主
     */
    @Override
    public List<SysBarOwner> selectSysBarOwnerList(SysBarOwner sysBarOwner)
    {
        return sysBarOwnerMapper.selectSysBarOwnerList(sysBarOwner);
    }

    /**
     * 新增吧主
     * 
     * @param sysBarOwner 吧主
     * @return 结果
     */
    @Override
    public int insertSysBarOwner(SysBarOwner sysBarOwner)
    {
        return sysBarOwnerMapper.insertSysBarOwner(sysBarOwner);
    }

    /**
     * 修改吧主
     * 
     * @param sysBarOwner 吧主
     * @return 结果
     */
    @Override
    public int updateSysBarOwner(SysBarOwner sysBarOwner)
    {
        return sysBarOwnerMapper.updateSysBarOwner(sysBarOwner);
    }

    /**
     * 批量删除吧主
     * 
     * @param ids 需要删除的吧主ID
     * @return 结果
     */
    @Override
    public int deleteSysBarOwnerByIds(Long[] ids)
    {
        return sysBarOwnerMapper.deleteSysBarOwnerByIds(ids);
    }

    /**
     * 删除吧主信息
     * 
     * @param id 吧主ID
     * @return 结果
     */
    @Override
    public int deleteSysBarOwnerById(Long id)
    {
        return sysBarOwnerMapper.deleteSysBarOwnerById(id);
    }
}
