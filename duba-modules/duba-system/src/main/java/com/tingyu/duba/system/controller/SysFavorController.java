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
import com.tingyu.duba.system.domain.SysFavor;
import com.tingyu.duba.system.service.ISysFavorService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 收藏Controller
 */
@RestController
@RequestMapping("/favor")
public class SysFavorController extends BaseController {
    @Autowired
    private ISysFavorService sysFavorService;

    /**
     * 查询收藏列表
     */
    @PreAuthorize(hasPermi = "system:favor:list")
    @GetMapping("/list")
    public TableDataInfo list(SysFavor sysFavor) {
        startPage();
        List<SysFavor> list = sysFavorService.selectSysFavorList(sysFavor);
        return getDataTable(list);
    }

    /**
     * 导出收藏列表
     */
    @PreAuthorize(hasPermi = "system:favor:export")
    @Log(title = "收藏", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFavor sysFavor) throws IOException {
        List<SysFavor> list = sysFavorService.selectSysFavorList(sysFavor);
        ExcelUtil<SysFavor> util = new ExcelUtil<SysFavor>(SysFavor.class);
        util.exportExcel(response, list, "favor");
    }

    /**
     * 获取收藏详细信息
     */
    @PreAuthorize(hasPermi = "system:favor:query")
    @GetMapping(value = "/{favorId}")
    public AjaxResult getInfo(@PathVariable("favorId") Long favorId) {
        return AjaxResult.success(sysFavorService.selectSysFavorById(favorId));
    }

    /**
     * 新增收藏
     */
    @PreAuthorize(hasPermi = "system:favor:add")
    @Log(title = "收藏", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFavor sysFavor) {
        return toAjax(sysFavorService.insertSysFavor(sysFavor));
    }

    /**
     * 修改收藏
     */
    @PreAuthorize(hasPermi = "system:favor:edit")
    @Log(title = "收藏", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFavor sysFavor) {
        return toAjax(sysFavorService.updateSysFavor(sysFavor));
    }

    /**
     * 删除收藏
     */
    @PreAuthorize(hasPermi = "system:favor:remove")
    @Log(title = "收藏", operType = OperType.DELETE)
    @DeleteMapping("/{favorIds}")
    public AjaxResult remove(@PathVariable Long[] favorIds) {
        return toAjax(sysFavorService.deleteSysFavorByIds(favorIds));
    }
}
