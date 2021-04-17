package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysPostMapper;
import com.tingyu.duba.system.domain.SysPost;
import com.tingyu.duba.system.service.ISysPostService;

/**
 * 贴子Service业务层处理
 */
@Service
public class SysPostServiceImpl implements ISysPostService 
{
    @Autowired
    private SysPostMapper sysPostMapper;

    /**
     * 查询贴子
     * 
     * @param postId 贴子ID
     * @return 贴子
     */
    @Override
    public SysPost selectSysPostById(Long postId)
    {
        return sysPostMapper.selectSysPostById(postId);
    }

    /**
     * 查询贴子列表
     * 
     * @param sysPost 贴子
     * @return 贴子
     */
    @Override
    public List<SysPost> selectSysPostList(SysPost sysPost)
    {
        return sysPostMapper.selectSysPostList(sysPost);
    }

    /**
     * 新增贴子
     * 
     * @param sysPost 贴子
     * @return 结果
     */
    @Override
    public int insertSysPost(SysPost sysPost)
    {
        sysPost.setCreateTime(DateUtils.getNowDate());
        return sysPostMapper.insertSysPost(sysPost);
    }

    /**
     * 修改贴子
     * 
     * @param sysPost 贴子
     * @return 结果
     */
    @Override
    public int updateSysPost(SysPost sysPost)
    {
        sysPost.setUpdateTime(DateUtils.getNowDate());
        return sysPostMapper.updateSysPost(sysPost);
    }

    /**
     * 批量删除贴子
     * 
     * @param postIds 需要删除的贴子ID
     * @return 结果
     */
    @Override
    public int deleteSysPostByIds(Long[] postIds)
    {
        return sysPostMapper.deleteSysPostByIds(postIds);
    }

    /**
     * 删除贴子信息
     * 
     * @param postId 贴子ID
     * @return 结果
     */
    @Override
    public int deleteSysPostById(Long postId)
    {
        return sysPostMapper.deleteSysPostById(postId);
    }
}
