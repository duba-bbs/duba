package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysJobLog;

/**
 * 定时任务调度日志Service接口
 */
public interface ISysJobLogService 
{
    /**
     * 查询定时任务调度日志
     * 
     * @param jobLogId 定时任务调度日志ID
     * @return 定时任务调度日志
     */
    public SysJobLog selectSysJobLogById(Long jobLogId);

    /**
     * 查询定时任务调度日志列表
     * 
     * @param sysJobLog 定时任务调度日志
     * @return 定时任务调度日志集合
     */
    public List<SysJobLog> selectSysJobLogList(SysJobLog sysJobLog);

    /**
     * 新增定时任务调度日志
     * 
     * @param sysJobLog 定时任务调度日志
     * @return 结果
     */
    public int insertSysJobLog(SysJobLog sysJobLog);

    /**
     * 修改定时任务调度日志
     * 
     * @param sysJobLog 定时任务调度日志
     * @return 结果
     */
    public int updateSysJobLog(SysJobLog sysJobLog);

    /**
     * 批量删除定时任务调度日志
     * 
     * @param jobLogIds 需要删除的定时任务调度日志ID
     * @return 结果
     */
    public int deleteSysJobLogByIds(Long[] jobLogIds);

    /**
     * 删除定时任务调度日志信息
     * 
     * @param jobLogId 定时任务调度日志ID
     * @return 结果
     */
    public int deleteSysJobLogById(Long jobLogId);
}
