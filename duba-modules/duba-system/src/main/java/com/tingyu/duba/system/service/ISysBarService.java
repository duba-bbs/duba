package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysBar;

/**
 * 吧Service接口
 */
public interface ISysBarService 
{
    /**
     * 查询吧
     * 
     * @param barId 吧ID
     * @return 吧
     */
    public SysBar selectSysBarById(Long barId);

    /**
     * 查询吧列表
     * 
     * @param sysBar 吧
     * @return 吧集合
     */
    public List<SysBar> selectSysBarList(SysBar sysBar);

    /**
     * 新增吧
     * 
     * @param sysBar 吧
     * @return 结果
     */
    public int insertSysBar(SysBar sysBar);

    /**
     * 修改吧
     * 
     * @param sysBar 吧
     * @return 结果
     */
    public int updateSysBar(SysBar sysBar);

    /**
     * 批量删除吧
     * 
     * @param barIds 需要删除的吧ID
     * @return 结果
     */
    public int deleteSysBarByIds(Long[] barIds);

    /**
     * 删除吧信息
     * 
     * @param barId 吧ID
     * @return 结果
     */
    public int deleteSysBarById(Long barId);
}
