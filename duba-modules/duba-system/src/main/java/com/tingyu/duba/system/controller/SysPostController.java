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
import com.tingyu.duba.system.domain.SysPost;
import com.tingyu.duba.system.service.ISysPostService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 贴子Controller
 */
@RestController
@RequestMapping("/post")
public class SysPostController extends BaseController {
    @Autowired
    private ISysPostService sysPostService;

    /**
     * 查询贴子列表
     */
    @PreAuthorize(hasPermi = "system:post:list")
    @GetMapping("/list")
    public TableDataInfo list(SysPost sysPost) {
        startPage();
        List<SysPost> list = sysPostService.selectSysPostList(sysPost);
        return getDataTable(list);
    }

    /**
     * 导出贴子列表
     */
    @PreAuthorize(hasPermi = "system:post:export")
    @Log(title = "贴子", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPost sysPost) throws IOException {
        List<SysPost> list = sysPostService.selectSysPostList(sysPost);
        ExcelUtil<SysPost> util = new ExcelUtil<SysPost>(SysPost.class);
        util.exportExcel(response, list, "post");
    }

    /**
     * 获取贴子详细信息
     */
    @PreAuthorize(hasPermi = "system:post:query")
    @GetMapping(value = "/{postId}")
    public AjaxResult getInfo(@PathVariable("postId") Long postId) {
        return AjaxResult.success(sysPostService.selectSysPostById(postId));
    }

    /**
     * 新增贴子
     */
    @PreAuthorize(hasPermi = "system:post:add")
    @Log(title = "贴子", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPost sysPost) {
        return toAjax(sysPostService.insertSysPost(sysPost));
    }

    /**
     * 修改贴子
     */
    @PreAuthorize(hasPermi = "system:post:edit")
    @Log(title = "贴子", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPost sysPost) {
        return toAjax(sysPostService.updateSysPost(sysPost));
    }

    /**
     * 删除贴子
     */
    @PreAuthorize(hasPermi = "system:post:remove")
    @Log(title = "贴子", operType = OperType.DELETE)
    @DeleteMapping("/{postIds}")
    public AjaxResult remove(@PathVariable Long[] postIds) {
        return toAjax(sysPostService.deleteSysPostByIds(postIds));
    }
}
