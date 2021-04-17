package com.tingyu.duba.system.mapper;

import java.util.List;
import com.tingyu.duba.system.domain.SysFavor;

/**
 * 收藏Mapper接口
 */
public interface SysFavorMapper 
{
    /**
     * 查询收藏
     * 
     * @param favorId 收藏ID
     * @return 收藏
     */
    public SysFavor selectSysFavorById(Long favorId);

    /**
     * 查询收藏列表
     * 
     * @param sysFavor 收藏
     * @return 收藏集合
     */
    public List<SysFavor> selectSysFavorList(SysFavor sysFavor);

    /**
     * 新增收藏
     * 
     * @param sysFavor 收藏
     * @return 结果
     */
    public int insertSysFavor(SysFavor sysFavor);

    /**
     * 修改收藏
     * 
     * @param sysFavor 收藏
     * @return 结果
     */
    public int updateSysFavor(SysFavor sysFavor);

    /**
     * 删除收藏
     * 
     * @param favorId 收藏ID
     * @return 结果
     */
    public int deleteSysFavorById(Long favorId);

    /**
     * 批量删除收藏
     * 
     * @param favorIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFavorByIds(Long[] favorIds);
}
