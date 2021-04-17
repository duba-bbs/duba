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
import com.tingyu.duba.system.domain.SysJobLog;
import com.tingyu.duba.system.service.ISysJobLogService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 定时任务调度日志Controller
 */
@RestController
@RequestMapping("/log")
public class SysJobLogController extends BaseController {
    @Autowired
    private ISysJobLogService sysJobLogService;

    /**
     * 查询定时任务调度日志列表
     */
    @PreAuthorize(hasPermi = "system:log:list")
    @GetMapping("/list")
    public TableDataInfo list(SysJobLog sysJobLog) {
        startPage();
        List<SysJobLog> list = sysJobLogService.selectSysJobLogList(sysJobLog);
        return getDataTable(list);
    }

    /**
     * 导出定时任务调度日志列表
     */
    @PreAuthorize(hasPermi = "system:log:export")
    @Log(title = "定时任务调度日志", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysJobLog sysJobLog) throws IOException {
        List<SysJobLog> list = sysJobLogService.selectSysJobLogList(sysJobLog);
        ExcelUtil<SysJobLog> util = new ExcelUtil<SysJobLog>(SysJobLog.class);
        util.exportExcel(response, list, "log");
    }

    /**
     * 获取定时任务调度日志详细信息
     */
    @PreAuthorize(hasPermi = "system:log:query")
    @GetMapping(value = "/{jobLogId}")
    public AjaxResult getInfo(@PathVariable("jobLogId") Long jobLogId) {
        return AjaxResult.success(sysJobLogService.selectSysJobLogById(jobLogId));
    }

    /**
     * 新增定时任务调度日志
     */
    @PreAuthorize(hasPermi = "system:log:add")
    @Log(title = "定时任务调度日志", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysJobLog sysJobLog) {
        return toAjax(sysJobLogService.insertSysJobLog(sysJobLog));
    }

    /**
     * 修改定时任务调度日志
     */
    @PreAuthorize(hasPermi = "system:log:edit")
    @Log(title = "定时任务调度日志", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysJobLog sysJobLog) {
        return toAjax(sysJobLogService.updateSysJobLog(sysJobLog));
    }

    /**
     * 删除定时任务调度日志
     */
    @PreAuthorize(hasPermi = "system:log:remove")
    @Log(title = "定时任务调度日志", operType = OperType.DELETE)
    @DeleteMapping("/{jobLogIds}")
    public AjaxResult remove(@PathVariable Long[] jobLogIds) {
        return toAjax(sysJobLogService.deleteSysJobLogByIds(jobLogIds));
    }
}
