package com.tingyu.duba.system.service.impl;

import java.util.List;

import com.tingyu.duba.system.api.domain.SysOperLog;
import com.tingyu.duba.system.mapper.SysOperLogMapper;
import com.tingyu.duba.system.service.ISysOperLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 操作日志记录Service业务层处理
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService {
    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    /**
     * 查询操作日志记录
     * 
     * @param operId
     *            操作日志记录ID
     * @return 操作日志记录
     */
    @Override
    public SysOperLog selectSysOperLogById(Long operId) {
        return sysOperLogMapper.selectSysOperLogById(operId);
    }

    /**
     * 查询操作日志记录列表
     * 
     * @param sysOperLog
     *            操作日志记录
     * @return 操作日志记录
     */
    @Override
    public List<SysOperLog> selectSysOperLogList(SysOperLog sysOperLog) {
        return sysOperLogMapper.selectSysOperLogList(sysOperLog);
    }

    /**
     * 新增操作日志记录
     * 
     * @param sysOperLog
     *            操作日志记录
     * @return 结果
     */
    @Override
    public int insertSysOperLog(SysOperLog sysOperLog) {
        return sysOperLogMapper.insertSysOperLog(sysOperLog);
    }

    /**
     * 修改操作日志记录
     * 
     * @param sysOperLog
     *            操作日志记录
     * @return 结果
     */
    @Override
    public int updateSysOperLog(SysOperLog sysOperLog) {
        return sysOperLogMapper.updateSysOperLog(sysOperLog);
    }

    /**
     * 批量删除操作日志记录
     * 
     * @param operIds
     *            需要删除的操作日志记录ID
     * @return 结果
     */
    @Override
    public int deleteSysOperLogByIds(Long[] operIds) {
        return sysOperLogMapper.deleteSysOperLogByIds(operIds);
    }

    /**
     * 删除操作日志记录信息
     * 
     * @param operId
     *            操作日志记录ID
     * @return 结果
     */
    @Override
    public int deleteSysOperLogById(Long operId) {
        return sysOperLogMapper.deleteSysOperLogById(operId);
    }
}
