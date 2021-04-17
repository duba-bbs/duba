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
import com.tingyu.duba.system.domain.SysJob;
import com.tingyu.duba.system.service.ISysJobService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 定时任务调度Controller
 */
@RestController
@RequestMapping("/job")
public class SysJobController extends BaseController {
    @Autowired
    private ISysJobService sysJobService;

    /**
     * 查询定时任务调度列表
     */
    @PreAuthorize(hasPermi = "system:job:list")
    @GetMapping("/list")
    public TableDataInfo list(SysJob sysJob) {
        startPage();
        List<SysJob> list = sysJobService.selectSysJobList(sysJob);
        return getDataTable(list);
    }

    /**
     * 导出定时任务调度列表
     */
    @PreAuthorize(hasPermi = "system:job:export")
    @Log(title = "定时任务调度", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysJob sysJob) throws IOException {
        List<SysJob> list = sysJobService.selectSysJobList(sysJob);
        ExcelUtil<SysJob> util = new ExcelUtil<SysJob>(SysJob.class);
        util.exportExcel(response, list, "job");
    }

    /**
     * 获取定时任务调度详细信息
     */
    @PreAuthorize(hasPermi = "system:job:query")
    @GetMapping(value = "/{jobId}")
    public AjaxResult getInfo(@PathVariable("jobId") Long jobId) {
        return AjaxResult.success(sysJobService.selectSysJobById(jobId));
    }

    /**
     * 新增定时任务调度
     */
    @PreAuthorize(hasPermi = "system:job:add")
    @Log(title = "定时任务调度", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysJob sysJob) {
        return toAjax(sysJobService.insertSysJob(sysJob));
    }

    /**
     * 修改定时任务调度
     */
    @PreAuthorize(hasPermi = "system:job:edit")
    @Log(title = "定时任务调度", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysJob sysJob) {
        return toAjax(sysJobService.updateSysJob(sysJob));
    }

    /**
     * 删除定时任务调度
     */
    @PreAuthorize(hasPermi = "system:job:remove")
    @Log(title = "定时任务调度", operType = OperType.DELETE)
    @DeleteMapping("/{jobIds}")
    public AjaxResult remove(@PathVariable Long[] jobIds) {
        return toAjax(sysJobService.deleteSysJobByIds(jobIds));
    }
}
