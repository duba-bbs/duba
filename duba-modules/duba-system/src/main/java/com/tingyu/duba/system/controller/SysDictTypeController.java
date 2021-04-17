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
import com.tingyu.duba.system.domain.SysDictType;
import com.tingyu.duba.system.service.ISysDictTypeService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 字典类型Controller
 */
@RestController
@RequestMapping("/type")
public class SysDictTypeController extends BaseController {
    @Autowired
    private ISysDictTypeService sysDictTypeService;

    /**
     * 查询字典类型列表
     */
    @PreAuthorize(hasPermi = "system:type:list")
    @GetMapping("/list")
    public TableDataInfo list(SysDictType sysDictType) {
        startPage();
        List<SysDictType> list = sysDictTypeService.selectSysDictTypeList(sysDictType);
        return getDataTable(list);
    }

    /**
     * 导出字典类型列表
     */
    @PreAuthorize(hasPermi = "system:type:export")
    @Log(title = "字典类型", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictType sysDictType) throws IOException {
        List<SysDictType> list = sysDictTypeService.selectSysDictTypeList(sysDictType);
        ExcelUtil<SysDictType> util = new ExcelUtil<SysDictType>(SysDictType.class);
        util.exportExcel(response, list, "type");
    }

    /**
     * 获取字典类型详细信息
     */
    @PreAuthorize(hasPermi = "system:type:query")
    @GetMapping(value = "/{dictId}")
    public AjaxResult getInfo(@PathVariable("dictId") Long dictId) {
        return AjaxResult.success(sysDictTypeService.selectSysDictTypeById(dictId));
    }

    /**
     * 新增字典类型
     */
    @PreAuthorize(hasPermi = "system:type:add")
    @Log(title = "字典类型", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDictType sysDictType) {
        return toAjax(sysDictTypeService.insertSysDictType(sysDictType));
    }

    /**
     * 修改字典类型
     */
    @PreAuthorize(hasPermi = "system:type:edit")
    @Log(title = "字典类型", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDictType sysDictType) {
        return toAjax(sysDictTypeService.updateSysDictType(sysDictType));
    }

    /**
     * 删除字典类型
     */
    @PreAuthorize(hasPermi = "system:type:remove")
    @Log(title = "字典类型", operType = OperType.DELETE)
    @DeleteMapping("/{dictIds}")
    public AjaxResult remove(@PathVariable Long[] dictIds) {
        return toAjax(sysDictTypeService.deleteSysDictTypeByIds(dictIds));
    }
}
