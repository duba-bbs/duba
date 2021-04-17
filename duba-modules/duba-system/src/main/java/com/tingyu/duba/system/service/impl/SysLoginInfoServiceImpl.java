package com.tingyu.duba.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tingyu.duba.system.mapper.SysLoginInfoMapper;
import com.tingyu.duba.system.domain.SysLoginInfo;
import com.tingyu.duba.system.service.ISysLoginInfoService;

/**
 * 系统访问记录Service业务层处理
 */
@Service
public class SysLoginInfoServiceImpl implements ISysLoginInfoService {
    @Autowired
    private SysLoginInfoMapper sysLoginInfoMapper;

    /**
     * 新增系统访问记录
     * 
     * @param sysLoginInfo
     *            系统访问记录
     * @return 结果
     */
    @Override
    public int insertSysLoginInfo(SysLoginInfo sysLoginInfo) {
        return sysLoginInfoMapper.insertSysLoginInfo(sysLoginInfo);
    }
}
