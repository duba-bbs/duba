package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysBarOwner;

/**
 * 吧主Service接口
 */
public interface ISysBarOwnerService 
{
    /**
     * 查询吧主
     * 
     * @param id 吧主ID
     * @return 吧主
     */
    public SysBarOwner selectSysBarOwnerById(Long id);

    /**
     * 查询吧主列表
     * 
     * @param sysBarOwner 吧主
     * @return 吧主集合
     */
    public List<SysBarOwner> selectSysBarOwnerList(SysBarOwner sysBarOwner);

    /**
     * 新增吧主
     * 
     * @param sysBarOwner 吧主
     * @return 结果
     */
    public int insertSysBarOwner(SysBarOwner sysBarOwner);

    /**
     * 修改吧主
     * 
     * @param sysBarOwner 吧主
     * @return 结果
     */
    public int updateSysBarOwner(SysBarOwner sysBarOwner);

    /**
     * 批量删除吧主
     * 
     * @param ids 需要删除的吧主ID
     * @return 结果
     */
    public int deleteSysBarOwnerByIds(Long[] ids);

    /**
     * 删除吧主信息
     * 
     * @param id 吧主ID
     * @return 结果
     */
    public int deleteSysBarOwnerById(Long id);
}
