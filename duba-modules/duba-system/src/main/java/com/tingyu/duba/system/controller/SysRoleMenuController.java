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
import com.tingyu.duba.system.domain.SysRoleMenu;
import com.tingyu.duba.system.service.ISysRoleMenuService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 角色和菜单关联Controller
 */
@RestController
@RequestMapping("/rolemenu")
public class SysRoleMenuController extends BaseController {
    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    /**
     * 查询角色和菜单关联列表
     */
    @PreAuthorize(hasPermi = "system:menu:list")
    @GetMapping("/list")
    public TableDataInfo list(SysRoleMenu sysRoleMenu) {
        startPage();
        List<SysRoleMenu> list = sysRoleMenuService.selectSysRoleMenuList(sysRoleMenu);
        return getDataTable(list);
    }

    /**
     * 导出角色和菜单关联列表
     */
    @PreAuthorize(hasPermi = "system:menu:export")
    @Log(title = "角色和菜单关联", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRoleMenu sysRoleMenu) throws IOException {
        List<SysRoleMenu> list = sysRoleMenuService.selectSysRoleMenuList(sysRoleMenu);
        ExcelUtil<SysRoleMenu> util = new ExcelUtil<SysRoleMenu>(SysRoleMenu.class);
        util.exportExcel(response, list, "menu");
    }

    /**
     * 获取角色和菜单关联详细信息
     */
    @PreAuthorize(hasPermi = "system:menu:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysRoleMenuService.selectSysRoleMenuById(id));
    }

    /**
     * 新增角色和菜单关联
     */
    @PreAuthorize(hasPermi = "system:menu:add")
    @Log(title = "角色和菜单关联", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRoleMenu sysRoleMenu) {
        return toAjax(sysRoleMenuService.insertSysRoleMenu(sysRoleMenu));
    }

    /**
     * 修改角色和菜单关联
     */
    @PreAuthorize(hasPermi = "system:menu:edit")
    @Log(title = "角色和菜单关联", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRoleMenu sysRoleMenu) {
        return toAjax(sysRoleMenuService.updateSysRoleMenu(sysRoleMenu));
    }

    /**
     * 删除角色和菜单关联
     */
    @PreAuthorize(hasPermi = "system:menu:remove")
    @Log(title = "角色和菜单关联", operType = OperType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysRoleMenuService.deleteSysRoleMenuByIds(ids));
    }
}
