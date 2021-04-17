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
import com.tingyu.duba.system.domain.SysComment;
import com.tingyu.duba.system.service.ISysCommentService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 评论Controller
 */
@RestController
@RequestMapping("/comment")
public class SysCommentController extends BaseController {
    @Autowired
    private ISysCommentService sysCommentService;

    /**
     * 查询评论列表
     */
    @PreAuthorize(hasPermi = "system:comment:list")
    @GetMapping("/list")
    public TableDataInfo list(SysComment sysComment) {
        startPage();
        List<SysComment> list = sysCommentService.selectSysCommentList(sysComment);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @PreAuthorize(hasPermi = "system:comment:export")
    @Log(title = "评论", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysComment sysComment) throws IOException {
        List<SysComment> list = sysCommentService.selectSysCommentList(sysComment);
        ExcelUtil<SysComment> util = new ExcelUtil<SysComment>(SysComment.class);
        util.exportExcel(response, list, "comment");
    }

    /**
     * 获取评论详细信息
     */
    @PreAuthorize(hasPermi = "system:comment:query")
    @GetMapping(value = "/{commentId}")
    public AjaxResult getInfo(@PathVariable("commentId") Long commentId) {
        return AjaxResult.success(sysCommentService.selectSysCommentById(commentId));
    }

    /**
     * 新增评论
     */
    @PreAuthorize(hasPermi = "system:comment:add")
    @Log(title = "评论", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysComment sysComment) {
        return toAjax(sysCommentService.insertSysComment(sysComment));
    }

    /**
     * 修改评论
     */
    @PreAuthorize(hasPermi = "system:comment:edit")
    @Log(title = "评论", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysComment sysComment) {
        return toAjax(sysCommentService.updateSysComment(sysComment));
    }

    /**
     * 删除评论
     */
    @PreAuthorize(hasPermi = "system:comment:remove")
    @Log(title = "评论", operType = OperType.DELETE)
    @DeleteMapping("/{commentIds}")
    public AjaxResult remove(@PathVariable Long[] commentIds) {
        return toAjax(sysCommentService.deleteSysCommentByIds(commentIds));
    }
}
