package com.tingyu.duba.system.service.impl;

import java.util.List;
import com.tingyu.duba.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysFavorMapper;
import com.tingyu.duba.system.domain.SysFavor;
import com.tingyu.duba.system.service.ISysFavorService;

/**
 * 收藏Service业务层处理
 */
@Service
public class SysFavorServiceImpl implements ISysFavorService 
{
    @Autowired
    private SysFavorMapper sysFavorMapper;

    /**
     * 查询收藏
     * 
     * @param favorId 收藏ID
     * @return 收藏
     */
    @Override
    public SysFavor selectSysFavorById(Long favorId)
    {
        return sysFavorMapper.selectSysFavorById(favorId);
    }

    /**
     * 查询收藏列表
     * 
     * @param sysFavor 收藏
     * @return 收藏
     */
    @Override
    public List<SysFavor> selectSysFavorList(SysFavor sysFavor)
    {
        return sysFavorMapper.selectSysFavorList(sysFavor);
    }

    /**
     * 新增收藏
     * 
     * @param sysFavor 收藏
     * @return 结果
     */
    @Override
    public int insertSysFavor(SysFavor sysFavor)
    {
        sysFavor.setCreateTime(DateUtils.getNowDate());
        return sysFavorMapper.insertSysFavor(sysFavor);
    }

    /**
     * 修改收藏
     * 
     * @param sysFavor 收藏
     * @return 结果
     */
    @Override
    public int updateSysFavor(SysFavor sysFavor)
    {
        sysFavor.setUpdateTime(DateUtils.getNowDate());
        return sysFavorMapper.updateSysFavor(sysFavor);
    }

    /**
     * 批量删除收藏
     * 
     * @param favorIds 需要删除的收藏ID
     * @return 结果
     */
    @Override
    public int deleteSysFavorByIds(Long[] favorIds)
    {
        return sysFavorMapper.deleteSysFavorByIds(favorIds);
    }

    /**
     * 删除收藏信息
     * 
     * @param favorId 收藏ID
     * @return 结果
     */
    @Override
    public int deleteSysFavorById(Long favorId)
    {
        return sysFavorMapper.deleteSysFavorById(favorId);
    }
}
