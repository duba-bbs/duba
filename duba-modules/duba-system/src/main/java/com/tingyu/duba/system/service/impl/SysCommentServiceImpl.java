package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysCommentMapper;
import com.tingyu.duba.system.domain.SysComment;
import com.tingyu.duba.system.service.ISysCommentService;

/**
 * 评论Service业务层处理
 */
@Service
public class SysCommentServiceImpl implements ISysCommentService 
{
    @Autowired
    private SysCommentMapper sysCommentMapper;

    /**
     * 查询评论
     * 
     * @param commentId 评论ID
     * @return 评论
     */
    @Override
    public SysComment selectSysCommentById(Long commentId)
    {
        return sysCommentMapper.selectSysCommentById(commentId);
    }

    /**
     * 查询评论列表
     * 
     * @param sysComment 评论
     * @return 评论
     */
    @Override
    public List<SysComment> selectSysCommentList(SysComment sysComment)
    {
        return sysCommentMapper.selectSysCommentList(sysComment);
    }

    /**
     * 新增评论
     * 
     * @param sysComment 评论
     * @return 结果
     */
    @Override
    public int insertSysComment(SysComment sysComment)
    {
        sysComment.setCreateTime(DateUtils.getNowDate());
        return sysCommentMapper.insertSysComment(sysComment);
    }

    /**
     * 修改评论
     * 
     * @param sysComment 评论
     * @return 结果
     */
    @Override
    public int updateSysComment(SysComment sysComment)
    {
        sysComment.setUpdateTime(DateUtils.getNowDate());
        return sysCommentMapper.updateSysComment(sysComment);
    }

    /**
     * 批量删除评论
     * 
     * @param commentIds 需要删除的评论ID
     * @return 结果
     */
    @Override
    public int deleteSysCommentByIds(Long[] commentIds)
    {
        return sysCommentMapper.deleteSysCommentByIds(commentIds);
    }

    /**
     * 删除评论信息
     * 
     * @param commentId 评论ID
     * @return 结果
     */
    @Override
    public int deleteSysCommentById(Long commentId)
    {
        return sysCommentMapper.deleteSysCommentById(commentId);
    }
}
