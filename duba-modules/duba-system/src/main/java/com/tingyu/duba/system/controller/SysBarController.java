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
import com.tingyu.duba.system.domain.SysBar;
import com.tingyu.duba.system.service.ISysBarService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 吧Controller
 */
@RestController
@RequestMapping("/bar")
public class SysBarController extends BaseController {
    @Autowired
    private ISysBarService sysBarService;

    /**
     * 查询吧列表
     */
    @PreAuthorize(hasPermi = "system:bar:list")
    @GetMapping("/list")
    public TableDataInfo list(SysBar sysBar) {
        startPage();
        List<SysBar> list = sysBarService.selectSysBarList(sysBar);
        return getDataTable(list);
    }

    /**
     * 导出吧列表
     */
    @PreAuthorize(hasPermi = "system:bar:export")
    @Log(title = "吧", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysBar sysBar) throws IOException {
        List<SysBar> list = sysBarService.selectSysBarList(sysBar);
        ExcelUtil<SysBar> util = new ExcelUtil<SysBar>(SysBar.class);
        util.exportExcel(response, list, "bar");
    }

    /**
     * 获取吧详细信息
     */
    @PreAuthorize(hasPermi = "system:bar:query")
    @GetMapping(value = "/{barId}")
    public AjaxResult getInfo(@PathVariable("barId") Long barId) {
        return AjaxResult.success(sysBarService.selectSysBarById(barId));
    }

    /**
     * 新增吧
     */
    @PreAuthorize(hasPermi = "system:bar:add")
    @Log(title = "吧", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBar sysBar) {
        return toAjax(sysBarService.insertSysBar(sysBar));
    }

    /**
     * 修改吧
     */
    @PreAuthorize(hasPermi = "system:bar:edit")
    @Log(title = "吧", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBar sysBar) {
        return toAjax(sysBarService.updateSysBar(sysBar));
    }

    /**
     * 删除吧
     */
    @PreAuthorize(hasPermi = "system:bar:remove")
    @Log(title = "吧", operType = OperType.DELETE)
    @DeleteMapping("/{barIds}")
    public AjaxResult remove(@PathVariable Long[] barIds) {
        return toAjax(sysBarService.deleteSysBarByIds(barIds));
    }
}
