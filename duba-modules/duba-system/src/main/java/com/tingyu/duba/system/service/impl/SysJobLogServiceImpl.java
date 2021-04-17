package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysJobLogMapper;
import com.tingyu.duba.system.domain.SysJobLog;
import com.tingyu.duba.system.service.ISysJobLogService;

/**
 * 定时任务调度日志Service业务层处理
 */
@Service
public class SysJobLogServiceImpl implements ISysJobLogService 
{
    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    /**
     * 查询定时任务调度日志
     * 
     * @param jobLogId 定时任务调度日志ID
     * @return 定时任务调度日志
     */
    @Override
    public SysJobLog selectSysJobLogById(Long jobLogId)
    {
        return sysJobLogMapper.selectSysJobLogById(jobLogId);
    }

    /**
     * 查询定时任务调度日志列表
     * 
     * @param sysJobLog 定时任务调度日志
     * @return 定时任务调度日志
     */
    @Override
    public List<SysJobLog> selectSysJobLogList(SysJobLog sysJobLog)
    {
        return sysJobLogMapper.selectSysJobLogList(sysJobLog);
    }

    /**
     * 新增定时任务调度日志
     * 
     * @param sysJobLog 定时任务调度日志
     * @return 结果
     */
    @Override
    public int insertSysJobLog(SysJobLog sysJobLog)
    {
        sysJobLog.setCreateTime(DateUtils.getNowDate());
        return sysJobLogMapper.insertSysJobLog(sysJobLog);
    }

    /**
     * 修改定时任务调度日志
     * 
     * @param sysJobLog 定时任务调度日志
     * @return 结果
     */
    @Override
    public int updateSysJobLog(SysJobLog sysJobLog)
    {
        return sysJobLogMapper.updateSysJobLog(sysJobLog);
    }

    /**
     * 批量删除定时任务调度日志
     * 
     * @param jobLogIds 需要删除的定时任务调度日志ID
     * @return 结果
     */
    @Override
    public int deleteSysJobLogByIds(Long[] jobLogIds)
    {
        return sysJobLogMapper.deleteSysJobLogByIds(jobLogIds);
    }

    /**
     * 删除定时任务调度日志信息
     * 
     * @param jobLogId 定时任务调度日志ID
     * @return 结果
     */
    @Override
    public int deleteSysJobLogById(Long jobLogId)
    {
        return sysJobLogMapper.deleteSysJobLogById(jobLogId);
    }
}
