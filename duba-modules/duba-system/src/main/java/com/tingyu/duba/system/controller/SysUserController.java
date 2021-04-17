package com.tingyu.duba.system.controller;

import java.util.Set;

import com.tingyu.duba.common.core.domain.R;
import com.tingyu.duba.common.core.utils.StringUtils;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.system.api.domain.SysUser;
import com.tingyu.duba.system.api.model.LoginUser;
import com.tingyu.duba.system.service.ISysPermissionService;
import com.tingyu.duba.system.service.ISysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息Controller
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysPermissionService permissionService;

    @GetMapping("/info/{username}")
    public R<LoginUser> getInfo(@PathVariable("username") String username) {
        SysUser sysUser = sysUserService.selectSysUserByUsername(username);
        if (StringUtils.isNull(sysUser)) {
            return R.fail("用户名或密码错误");
        }
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(sysUser.getUserId(), sysUser.getUserType());
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(sysUser.getUserId(), sysUser.getUserType());
        LoginUser sysUserVo = new LoginUser();
        sysUserVo.setSysUser(sysUser);
        sysUserVo.setRoles(roles);
        sysUserVo.setPermissions(permissions);
        return R.ok(sysUserVo);
    }

}
