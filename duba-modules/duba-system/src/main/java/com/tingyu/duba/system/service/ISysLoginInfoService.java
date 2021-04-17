package com.tingyu.duba.system.service;

import java.util.List;
import com.tingyu.duba.system.domain.SysLoginInfo;

/**
 * 系统访问记录Service接口
 */
public interface ISysLoginInfoService {
    /**
     * 新增系统访问记录
     * 
     * @param sysLoginInfo
     *            系统访问记录
     * @return 结果
     */
    public int insertSysLoginInfo(SysLoginInfo sysLoginInfo);

}
