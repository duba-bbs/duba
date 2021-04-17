package com.tingyu.duba.system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.web.page.TableDataInfo;
import com.tingyu.duba.common.log.annotation.Log;
import com.tingyu.duba.common.log.enums.OperType;
import com.tingyu.duba.common.security.annotation.PreAuthorize;
import com.tingyu.duba.system.api.domain.SysOperLog;
import com.tingyu.duba.system.service.ISysOperLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作日志记录Controller
 */
@RestController
@RequestMapping("/log")
public class SysOperLogController extends BaseController {
    @Autowired
    private ISysOperLogService sysOperLogService;

    /**
     * 查询操作日志记录列表
     */
    @PreAuthorize(hasPermi = "system:log:list")
    @GetMapping("/list")
    public TableDataInfo list(SysOperLog sysOperLog) {
        startPage();
        List<SysOperLog> list = sysOperLogService.selectSysOperLogList(sysOperLog);
        return getDataTable(list);
    }

    /**
     * 导出操作日志记录列表
     */
    @PreAuthorize(hasPermi = "system:log:export")
    @Log(title = "操作日志记录", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperLog sysOperLog) throws IOException {
        List<SysOperLog> list = sysOperLogService.selectSysOperLogList(sysOperLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        util.exportExcel(response, list, "log");
    }

    /**
     * 获取操作日志记录详细信息
     */
    @PreAuthorize(hasPermi = "system:log:query")
    @GetMapping(value = "/{operId}")
    public AjaxResult getInfo(@PathVariable("operId") Long operId) {
        return AjaxResult.success(sysOperLogService.selectSysOperLogById(operId));
    }

    /**
     * 新增操作日志记录
     */
    @PreAuthorize(hasPermi = "system:log:add")
    @Log(title = "操作日志记录", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysOperLog sysOperLog) {
        return toAjax(sysOperLogService.insertSysOperLog(sysOperLog));
    }

    /**
     * 修改操作日志记录
     */
    @PreAuthorize(hasPermi = "system:log:edit")
    @Log(title = "操作日志记录", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysOperLog sysOperLog) {
        return toAjax(sysOperLogService.updateSysOperLog(sysOperLog));
    }

    /**
     * 删除操作日志记录
     */
    @PreAuthorize(hasPermi = "system:log:remove")
    @Log(title = "操作日志记录", operType = OperType.DELETE)
    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Long[] operIds) {
        return toAjax(sysOperLogService.deleteSysOperLogByIds(operIds));
    }
}
