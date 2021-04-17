package com.tingyu.duba.system.mapper;

import java.util.List;
import com.tingyu.duba.system.domain.SysLoginInfo;

/**
 * 系统访问记录Mapper接口
 */
public interface SysLoginInfoMapper {
    /**
     * 新增系统访问记录
     * 
     * @param sysLoginInfo
     *            系统访问记录
     * @return 结果
     */
    public int insertSysLoginInfo(SysLoginInfo sysLoginInfo);

}
