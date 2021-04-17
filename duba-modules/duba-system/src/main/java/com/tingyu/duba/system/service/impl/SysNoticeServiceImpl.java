package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysNoticeMapper;
import com.tingyu.duba.system.domain.SysNotice;
import com.tingyu.duba.system.service.ISysNoticeService;

/**
 * 通知公告Service业务层处理
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService 
{
    @Autowired
    private SysNoticeMapper sysNoticeMapper;

    /**
     * 查询通知公告
     * 
     * @param noticeId 通知公告ID
     * @return 通知公告
     */
    @Override
    public SysNotice selectSysNoticeById(Long noticeId)
    {
        return sysNoticeMapper.selectSysNoticeById(noticeId);
    }

    /**
     * 查询通知公告列表
     * 
     * @param sysNotice 通知公告
     * @return 通知公告
     */
    @Override
    public List<SysNotice> selectSysNoticeList(SysNotice sysNotice)
    {
        return sysNoticeMapper.selectSysNoticeList(sysNotice);
    }

    /**
     * 新增通知公告
     * 
     * @param sysNotice 通知公告
     * @return 结果
     */
    @Override
    public int insertSysNotice(SysNotice sysNotice)
    {
        sysNotice.setCreateTime(DateUtils.getNowDate());
        return sysNoticeMapper.insertSysNotice(sysNotice);
    }

    /**
     * 修改通知公告
     * 
     * @param sysNotice 通知公告
     * @return 结果
     */
    @Override
    public int updateSysNotice(SysNotice sysNotice)
    {
        sysNotice.setUpdateTime(DateUtils.getNowDate());
        return sysNoticeMapper.updateSysNotice(sysNotice);
    }

    /**
     * 批量删除通知公告
     * 
     * @param noticeIds 需要删除的通知公告ID
     * @return 结果
     */
    @Override
    public int deleteSysNoticeByIds(Long[] noticeIds)
    {
        return sysNoticeMapper.deleteSysNoticeByIds(noticeIds);
    }

    /**
     * 删除通知公告信息
     * 
     * @param noticeId 通知公告ID
     * @return 结果
     */
    @Override
    public int deleteSysNoticeById(Long noticeId)
    {
        return sysNoticeMapper.deleteSysNoticeById(noticeId);
    }
}
