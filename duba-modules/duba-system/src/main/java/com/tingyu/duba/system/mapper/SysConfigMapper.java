package com.tingyu.duba.system.mapper;

import java.util.List;
import com.tingyu.duba.system.domain.SysConfig;

/**
 * 参数配置Mapper接口
 */
public interface SysConfigMapper 
{
    /**
     * 查询参数配置
     * 
     * @param configId 参数配置ID
     * @return 参数配置
     */
    public SysConfig selectSysConfigById(Long configId);

    /**
     * 查询参数配置列表
     * 
     * @param sysConfig 参数配置
     * @return 参数配置集合
     */
    public List<SysConfig> selectSysConfigList(SysConfig sysConfig);

    /**
     * 新增参数配置
     * 
     * @param sysConfig 参数配置
     * @return 结果
     */
    public int insertSysConfig(SysConfig sysConfig);

    /**
     * 修改参数配置
     * 
     * @param sysConfig 参数配置
     * @return 结果
     */
    public int updateSysConfig(SysConfig sysConfig);

    /**
     * 删除参数配置
     * 
     * @param configId 参数配置ID
     * @return 结果
     */
    public int deleteSysConfigById(Long configId);

    /**
     * 批量删除参数配置
     * 
     * @param configIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysConfigByIds(Long[] configIds);
}
