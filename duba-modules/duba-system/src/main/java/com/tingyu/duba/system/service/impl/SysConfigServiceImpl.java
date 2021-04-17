package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysConfigMapper;
import com.tingyu.duba.system.domain.SysConfig;
import com.tingyu.duba.system.service.ISysConfigService;

/**
 * 参数配置Service业务层处理
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService 
{
    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 查询参数配置
     * 
     * @param configId 参数配置ID
     * @return 参数配置
     */
    @Override
    public SysConfig selectSysConfigById(Long configId)
    {
        return sysConfigMapper.selectSysConfigById(configId);
    }

    /**
     * 查询参数配置列表
     * 
     * @param sysConfig 参数配置
     * @return 参数配置
     */
    @Override
    public List<SysConfig> selectSysConfigList(SysConfig sysConfig)
    {
        return sysConfigMapper.selectSysConfigList(sysConfig);
    }

    /**
     * 新增参数配置
     * 
     * @param sysConfig 参数配置
     * @return 结果
     */
    @Override
    public int insertSysConfig(SysConfig sysConfig)
    {
        sysConfig.setCreateTime(DateUtils.getNowDate());
        return sysConfigMapper.insertSysConfig(sysConfig);
    }

    /**
     * 修改参数配置
     * 
     * @param sysConfig 参数配置
     * @return 结果
     */
    @Override
    public int updateSysConfig(SysConfig sysConfig)
    {
        sysConfig.setUpdateTime(DateUtils.getNowDate());
        return sysConfigMapper.updateSysConfig(sysConfig);
    }

    /**
     * 批量删除参数配置
     * 
     * @param configIds 需要删除的参数配置ID
     * @return 结果
     */
    @Override
    public int deleteSysConfigByIds(Long[] configIds)
    {
        return sysConfigMapper.deleteSysConfigByIds(configIds);
    }

    /**
     * 删除参数配置信息
     * 
     * @param configId 参数配置ID
     * @return 结果
     */
    @Override
    public int deleteSysConfigById(Long configId)
    {
        return sysConfigMapper.deleteSysConfigById(configId);
    }
}
