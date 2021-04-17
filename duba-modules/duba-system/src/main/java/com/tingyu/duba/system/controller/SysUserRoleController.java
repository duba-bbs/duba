package com.tingyu.duba.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tingyu.duba.common.log.annotation.Log;
import com.tingyu.duba.common.log.enums.OperType;
import com.tingyu.duba.common.security.annotation.PreAuthorize;
import com.tingyu.duba.system.domain.SysUserRole;
import com.tingyu.duba.system.service.ISysUserRoleService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 用户和角色关联Controller
 */
@RestController
@RequestMapping("/role")
public class SysUserRoleController extends BaseController {
    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 查询用户和角色关联列表
     */
    @PreAuthorize(hasPermi = "system:role:list")
    @GetMapping("/list")
    public TableDataInfo list(SysUserRole sysUserRole) {
        startPage();
        List<SysUserRole> list = sysUserRoleService.selectSysUserRoleList(sysUserRole);
        return getDataTable(list);
    }

    /**
     * 导出用户和角色关联列表
     */
    @PreAuthorize(hasPermi = "system:role:export")
    @Log(title = "用户和角色关联", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUserRole sysUserRole) throws IOException {
        List<SysUserRole> list = sysUserRoleService.selectSysUserRoleList(sysUserRole);
        ExcelUtil<SysUserRole> util = new ExcelUtil<SysUserRole>(SysUserRole.class);
        util.exportExcel(response, list, "role");
    }

    /**
     * 获取用户和角色关联详细信息
     */
    @PreAuthorize(hasPermi = "system:role:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysUserRoleService.selectSysUserRoleById(id));
    }

    /**
     * 新增用户和角色关联
     */
    @PreAuthorize(hasPermi = "system:role:add")
    @Log(title = "用户和角色关联", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserRole sysUserRole) {
        return toAjax(sysUserRoleService.insertSysUserRole(sysUserRole));
    }

    /**
     * 修改用户和角色关联
     */
    @PreAuthorize(hasPermi = "system:role:edit")
    @Log(title = "用户和角色关联", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserRole sysUserRole) {
        return toAjax(sysUserRoleService.updateSysUserRole(sysUserRole));
    }

    /**
     * 删除用户和角色关联
     */
    @PreAuthorize(hasPermi = "system:role:remove")
    @Log(title = "用户和角色关联", operType = OperType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysUserRoleService.deleteSysUserRoleByIds(ids));
    }
}
