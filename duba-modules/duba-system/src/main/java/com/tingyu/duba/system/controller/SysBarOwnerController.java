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
import com.tingyu.duba.system.domain.SysBarOwner;
import com.tingyu.duba.system.service.ISysBarOwnerService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 吧主Controller
 */
@RestController
@RequestMapping("/owner")
public class SysBarOwnerController extends BaseController {
    @Autowired
    private ISysBarOwnerService sysBarOwnerService;

    /**
     * 查询吧主列表
     */
    @PreAuthorize(hasPermi = "system:owner:list")
    @GetMapping("/list")
    public TableDataInfo list(SysBarOwner sysBarOwner) {
        startPage();
        List<SysBarOwner> list = sysBarOwnerService.selectSysBarOwnerList(sysBarOwner);
        return getDataTable(list);
    }

    /**
     * 导出吧主列表
     */
    @PreAuthorize(hasPermi = "system:owner:export")
    @Log(title = "吧主", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysBarOwner sysBarOwner) throws IOException {
        List<SysBarOwner> list = sysBarOwnerService.selectSysBarOwnerList(sysBarOwner);
        ExcelUtil<SysBarOwner> util = new ExcelUtil<SysBarOwner>(SysBarOwner.class);
        util.exportExcel(response, list, "owner");
    }

    /**
     * 获取吧主详细信息
     */
    @PreAuthorize(hasPermi = "system:owner:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysBarOwnerService.selectSysBarOwnerById(id));
    }

    /**
     * 新增吧主
     */
    @PreAuthorize(hasPermi = "system:owner:add")
    @Log(title = "吧主", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBarOwner sysBarOwner) {
        return toAjax(sysBarOwnerService.insertSysBarOwner(sysBarOwner));
    }

    /**
     * 修改吧主
     */
    @PreAuthorize(hasPermi = "system:owner:edit")
    @Log(title = "吧主", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBarOwner sysBarOwner) {
        return toAjax(sysBarOwnerService.updateSysBarOwner(sysBarOwner));
    }

    /**
     * 删除吧主
     */
    @PreAuthorize(hasPermi = "system:owner:remove")
    @Log(title = "吧主", operType = OperType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysBarOwnerService.deleteSysBarOwnerByIds(ids));
    }
}
