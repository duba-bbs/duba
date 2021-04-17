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
import com.tingyu.duba.system.domain.SysNotice;
import com.tingyu.duba.system.service.ISysNoticeService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 通知公告Controller
 */
@RestController
@RequestMapping("/notice")
public class SysNoticeController extends BaseController {
    @Autowired
    private ISysNoticeService sysNoticeService;

    /**
     * 查询通知公告列表
     */
    @PreAuthorize(hasPermi = "system:notice:list")
    @GetMapping("/list")
    public TableDataInfo list(SysNotice sysNotice) {
        startPage();
        List<SysNotice> list = sysNoticeService.selectSysNoticeList(sysNotice);
        return getDataTable(list);
    }

    /**
     * 导出通知公告列表
     */
    @PreAuthorize(hasPermi = "system:notice:export")
    @Log(title = "通知公告", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysNotice sysNotice) throws IOException {
        List<SysNotice> list = sysNoticeService.selectSysNoticeList(sysNotice);
        ExcelUtil<SysNotice> util = new ExcelUtil<SysNotice>(SysNotice.class);
        util.exportExcel(response, list, "notice");
    }

    /**
     * 获取通知公告详细信息
     */
    @PreAuthorize(hasPermi = "system:notice:query")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId) {
        return AjaxResult.success(sysNoticeService.selectSysNoticeById(noticeId));
    }

    /**
     * 新增通知公告
     */
    @PreAuthorize(hasPermi = "system:notice:add")
    @Log(title = "通知公告", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysNotice sysNotice) {
        return toAjax(sysNoticeService.insertSysNotice(sysNotice));
    }

    /**
     * 修改通知公告
     */
    @PreAuthorize(hasPermi = "system:notice:edit")
    @Log(title = "通知公告", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysNotice sysNotice) {
        return toAjax(sysNoticeService.updateSysNotice(sysNotice));
    }

    /**
     * 删除通知公告
     */
    @PreAuthorize(hasPermi = "system:notice:remove")
    @Log(title = "通知公告", operType = OperType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds) {
        return toAjax(sysNoticeService.deleteSysNoticeByIds(noticeIds));
    }
}
