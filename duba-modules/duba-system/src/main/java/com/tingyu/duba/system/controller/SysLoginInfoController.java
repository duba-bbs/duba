package com.tingyu.duba.system.controller;

import com.tingyu.duba.common.core.constant.Constants;
import com.tingyu.duba.common.core.utils.ServletUtils;
import com.tingyu.duba.common.core.utils.ip.IpUtils;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.system.domain.SysLoginInfo;
import com.tingyu.duba.system.service.ISysLoginInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统访问记录Controller
 */
@RestController
@RequestMapping("/logininfo")
public class SysLoginInfoController extends BaseController {
    @Autowired
    private ISysLoginInfoService sysLoginInfoService;

    @PostMapping
    public AjaxResult add(@RequestParam("username") String username, @RequestParam("status") String status,
            @RequestParam("message") String message) {
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());

        // 封装对象
        SysLoginInfo loginInfo = new SysLoginInfo();
        loginInfo.setUsername(username);
        loginInfo.setLoginIp(ip);
        loginInfo.setMsg(message);
        // 日志状态
        if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
            loginInfo.setStatus("0");
        } else if (Constants.LOGIN_FAIL.equals(status)) {
            loginInfo.setStatus("1");
        }
        return toAjax(sysLoginInfoService.insertSysLoginInfo(loginInfo));
    }
}
