package com.tingyu.duba.system.mapper;

import java.util.List;
import com.tingyu.duba.system.domain.SysPost;

/**
 * 贴子Mapper接口
 */
public interface SysPostMapper 
{
    /**
     * 查询贴子
     * 
     * @param postId 贴子ID
     * @return 贴子
     */
    public SysPost selectSysPostById(Long postId);

    /**
     * 查询贴子列表
     * 
     * @param sysPost 贴子
     * @return 贴子集合
     */
    public List<SysPost> selectSysPostList(SysPost sysPost);

    /**
     * 新增贴子
     * 
     * @param sysPost 贴子
     * @return 结果
     */
    public int insertSysPost(SysPost sysPost);

    /**
     * 修改贴子
     * 
     * @param sysPost 贴子
     * @return 结果
     */
    public int updateSysPost(SysPost sysPost);

    /**
     * 删除贴子
     * 
     * @param postId 贴子ID
     * @return 结果
     */
    public int deleteSysPostById(Long postId);

    /**
     * 批量删除贴子
     * 
     * @param postIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysPostByIds(Long[] postIds);
}
