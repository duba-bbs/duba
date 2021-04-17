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
import com.tingyu.duba.system.domain.SysConfig;
import com.tingyu.duba.system.service.ISysConfigService;
import com.tingyu.duba.common.core.web.controller.BaseController;
import com.tingyu.duba.common.core.web.domain.AjaxResult;
import com.tingyu.duba.common.core.utils.poi.ExcelUtil;
import com.tingyu.duba.common.core.web.page.TableDataInfo;

/**
 * 参数配置Controller
 */
@RestController
@RequestMapping("/config")
public class SysConfigController extends BaseController {
    @Autowired
    private ISysConfigService sysConfigService;

    /**
     * 查询参数配置列表
     */
    @PreAuthorize(hasPermi = "system:config:list")
    @GetMapping("/list")
    public TableDataInfo list(SysConfig sysConfig) {
        startPage();
        List<SysConfig> list = sysConfigService.selectSysConfigList(sysConfig);
        return getDataTable(list);
    }

    /**
     * 导出参数配置列表
     */
    @PreAuthorize(hasPermi = "system:config:export")
    @Log(title = "参数配置", operType = OperType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysConfig sysConfig) throws IOException {
        List<SysConfig> list = sysConfigService.selectSysConfigList(sysConfig);
        ExcelUtil<SysConfig> util = new ExcelUtil<SysConfig>(SysConfig.class);
        util.exportExcel(response, list, "config");
    }

    /**
     * 获取参数配置详细信息
     */
    @PreAuthorize(hasPermi = "system:config:query")
    @GetMapping(value = "/{configId}")
    public AjaxResult getInfo(@PathVariable("configId") Long configId) {
        return AjaxResult.success(sysConfigService.selectSysConfigById(configId));
    }

    /**
     * 新增参数配置
     */
    @PreAuthorize(hasPermi = "system:config:add")
    @Log(title = "参数配置", operType = OperType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysConfig sysConfig) {
        return toAjax(sysConfigService.insertSysConfig(sysConfig));
    }

    /**
     * 修改参数配置
     */
    @PreAuthorize(hasPermi = "system:config:edit")
    @Log(title = "参数配置", operType = OperType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysConfig sysConfig) {
        return toAjax(sysConfigService.updateSysConfig(sysConfig));
    }

    /**
     * 删除参数配置
     */
    @PreAuthorize(hasPermi = "system:config:remove")
    @Log(title = "参数配置", operType = OperType.DELETE)
    @DeleteMapping("/{configIds}")
    public AjaxResult remove(@PathVariable Long[] configIds) {
        return toAjax(sysConfigService.deleteSysConfigByIds(configIds));
    }
}
