package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysDictType;

/**
 * 字典类型Service接口
 */
public interface ISysDictTypeService 
{
    /**
     * 查询字典类型
     * 
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    public SysDictType selectSysDictTypeById(Long dictId);

    /**
     * 查询字典类型列表
     * 
     * @param sysDictType 字典类型
     * @return 字典类型集合
     */
    public List<SysDictType> selectSysDictTypeList(SysDictType sysDictType);

    /**
     * 新增字典类型
     * 
     * @param sysDictType 字典类型
     * @return 结果
     */
    public int insertSysDictType(SysDictType sysDictType);

    /**
     * 修改字典类型
     * 
     * @param sysDictType 字典类型
     * @return 结果
     */
    public int updateSysDictType(SysDictType sysDictType);

    /**
     * 批量删除字典类型
     * 
     * @param dictIds 需要删除的字典类型ID
     * @return 结果
     */
    public int deleteSysDictTypeByIds(Long[] dictIds);

    /**
     * 删除字典类型信息
     * 
     * @param dictId 字典类型ID
     * @return 结果
     */
    public int deleteSysDictTypeById(Long dictId);
}
