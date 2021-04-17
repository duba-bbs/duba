package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysDictData;

/**
 * 字典数据Service接口
 */
public interface ISysDictDataService 
{
    /**
     * 查询字典数据
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    public SysDictData selectSysDictDataById(Long dictCode);

    /**
     * 查询字典数据列表
     * 
     * @param sysDictData 字典数据
     * @return 字典数据集合
     */
    public List<SysDictData> selectSysDictDataList(SysDictData sysDictData);

    /**
     * 新增字典数据
     * 
     * @param sysDictData 字典数据
     * @return 结果
     */
    public int insertSysDictData(SysDictData sysDictData);

    /**
     * 修改字典数据
     * 
     * @param sysDictData 字典数据
     * @return 结果
     */
    public int updateSysDictData(SysDictData sysDictData);

    /**
     * 批量删除字典数据
     * 
     * @param dictCodes 需要删除的字典数据ID
     * @return 结果
     */
    public int deleteSysDictDataByIds(Long[] dictCodes);

    /**
     * 删除字典数据信息
     * 
     * @param dictCode 字典数据ID
     * @return 结果
     */
    public int deleteSysDictDataById(Long dictCode);
}
