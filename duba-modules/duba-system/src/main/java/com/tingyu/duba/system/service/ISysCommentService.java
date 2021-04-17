package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysComment;

/**
 * 评论Service接口
 */
public interface ISysCommentService 
{
    /**
     * 查询评论
     * 
     * @param commentId 评论ID
     * @return 评论
     */
    public SysComment selectSysCommentById(Long commentId);

    /**
     * 查询评论列表
     * 
     * @param sysComment 评论
     * @return 评论集合
     */
    public List<SysComment> selectSysCommentList(SysComment sysComment);

    /**
     * 新增评论
     * 
     * @param sysComment 评论
     * @return 结果
     */
    public int insertSysComment(SysComment sysComment);

    /**
     * 修改评论
     * 
     * @param sysComment 评论
     * @return 结果
     */
    public int updateSysComment(SysComment sysComment);

    /**
     * 批量删除评论
     * 
     * @param commentIds 需要删除的评论ID
     * @return 结果
     */
    public int deleteSysCommentByIds(Long[] commentIds);

    /**
     * 删除评论信息
     * 
     * @param commentId 评论ID
     * @return 结果
     */
    public int deleteSysCommentById(Long commentId);
}
