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
import com.tingyu.duba.system.domain.SysDictData;
import com.tingyu.duba.system.service.ISysDictDataService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 字典数据Controller
 */
@RestController
@RequestMapping("/dictdata")
public class SysDictDataController extends BaseController {
    @Autowired
    private ISysDictDataService sysDictDataService;

    /**
     * 查询字典数据列表
     */
    @PreAuthorize(hasPermi = "system:data:list")
    @GetMapping("/list")
    public TableDataInfo list(SysDictData sysDictData) {
        startPage();
        List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
        return getDataTable(list);
    }

    /**
     * 导出字典数据列表
     */
    @PreAuthorize(hasPermi = "system:data:export")
    @Log(title = "字典数据", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictData sysDictData) throws IOException {
        List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
        ExcelUtil<SysDictData> util = new ExcelUtil<SysDictData>(SysDictData.class);
        util.exportExcel(response, list, "data");
    }

    /**
     * 获取字典数据详细信息
     */
    @PreAuthorize(hasPermi = "system:data:query")
    @GetMapping(value = "/{dictCode}")
    public AjaxResult getInfo(@PathVariable("dictCode") Long dictCode) {
        return AjaxResult.success(sysDictDataService.selectSysDictDataById(dictCode));
    }

    /**
     * 新增字典数据
     */
    @PreAuthorize(hasPermi = "system:data:add")
    @Log(title = "字典数据", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDictData sysDictData) {
        return toAjax(sysDictDataService.insertSysDictData(sysDictData));
    }

    /**
     * 修改字典数据
     */
    @PreAuthorize(hasPermi = "system:data:edit")
    @Log(title = "字典数据", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDictData sysDictData) {
        return toAjax(sysDictDataService.updateSysDictData(sysDictData));
    }

    /**
     * 删除字典数据
     */
    @PreAuthorize(hasPermi = "system:data:remove")
    @Log(title = "字典数据", operType = OperType.DELETE)
    @DeleteMapping("/{dictCodes}")
    public AjaxResult remove(@PathVariable Long[] dictCodes) {
        return toAjax(sysDictDataService.deleteSysDictDataByIds(dictCodes));
    }
}
