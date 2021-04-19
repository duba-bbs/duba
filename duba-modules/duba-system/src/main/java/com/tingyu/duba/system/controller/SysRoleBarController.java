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
import com.tingyu.duba.system.domain.SysRoleBar;
import com.tingyu.duba.system.service.ISysRoleBarService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 角色和吧关联Controller
 */
@RestController
@RequestMapping("/rolebar")
public class SysRoleBarController extends BaseController {
    @Autowired
    private ISysRoleBarService sysRoleBarService;

    /**
     * 查询角色和吧关联列表
     */
    @PreAuthorize(hasPermi = "system:bar:list")
    @GetMapping("/list")
    public TableDataInfo list(SysRoleBar sysRoleBar) {
        startPage();
        List<SysRoleBar> list = sysRoleBarService.selectSysRoleBarList(sysRoleBar);
        return getDataTable(list);
    }

    /**
     * 导出角色和吧关联列表
     */
    @PreAuthorize(hasPermi = "system:bar:export")
    @Log(title = "角色和吧关联", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRoleBar sysRoleBar) throws IOException {
        List<SysRoleBar> list = sysRoleBarService.selectSysRoleBarList(sysRoleBar);
        ExcelUtil<SysRoleBar> util = new ExcelUtil<SysRoleBar>(SysRoleBar.class);
        util.exportExcel(response, list, "bar");
    }

    /**
     * 获取角色和吧关联详细信息
     */
    @PreAuthorize(hasPermi = "system:bar:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysRoleBarService.selectSysRoleBarById(id));
    }

    /**
     * 新增角色和吧关联
     */
    @PreAuthorize(hasPermi = "system:bar:add")
    @Log(title = "角色和吧关联", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRoleBar sysRoleBar) {
        return toAjax(sysRoleBarService.insertSysRoleBar(sysRoleBar));
    }

    /**
     * 修改角色和吧关联
     */
    @PreAuthorize(hasPermi = "system:bar:edit")
    @Log(title = "角色和吧关联", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRoleBar sysRoleBar) {
        return toAjax(sysRoleBarService.updateSysRoleBar(sysRoleBar));
    }

    /**
     * 删除角色和吧关联
     */
    @PreAuthorize(hasPermi = "system:bar:remove")
    @Log(title = "角色和吧关联", operType = OperType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysRoleBarService.deleteSysRoleBarByIds(ids));
    }
}
