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
import com.tingyu.duba.system.domain.SysUserRel;
import com.tingyu.duba.system.service.ISysUserRelService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 用户关系Controller
 */
@RestController
@RequestMapping("/userrel")
public class SysUserRelController extends BaseController {
    @Autowired
    private ISysUserRelService sysUserRelService;

    /**
     * 查询用户关系列表
     */
    @PreAuthorize(hasPermi = "system:rel:list")
    @GetMapping("/list")
    public TableDataInfo list(SysUserRel sysUserRel) {
        startPage();
        List<SysUserRel> list = sysUserRelService.selectSysUserRelList(sysUserRel);
        return getDataTable(list);
    }

    /**
     * 导出用户关系列表
     */
    @PreAuthorize(hasPermi = "system:rel:export")
    @Log(title = "用户关系", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUserRel sysUserRel) throws IOException {
        List<SysUserRel> list = sysUserRelService.selectSysUserRelList(sysUserRel);
        ExcelUtil<SysUserRel> util = new ExcelUtil<SysUserRel>(SysUserRel.class);
        util.exportExcel(response, list, "rel");
    }

    /**
     * 获取用户关系详细信息
     */
    @PreAuthorize(hasPermi = "system:rel:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysUserRelService.selectSysUserRelById(id));
    }

    /**
     * 新增用户关系
     */
    @PreAuthorize(hasPermi = "system:rel:add")
    @Log(title = "用户关系", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserRel sysUserRel) {
        return toAjax(sysUserRelService.insertSysUserRel(sysUserRel));
    }

    /**
     * 修改用户关系
     */
    @PreAuthorize(hasPermi = "system:rel:edit")
    @Log(title = "用户关系", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserRel sysUserRel) {
        return toAjax(sysUserRelService.updateSysUserRel(sysUserRel));
    }

    /**
     * 删除用户关系
     */
    @PreAuthorize(hasPermi = "system:rel:remove")
    @Log(title = "用户关系", operType = OperType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysUserRelService.deleteSysUserRelByIds(ids));
    }
}
