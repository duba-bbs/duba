package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 字典数据对象 sys_dict_data
 */
public class SysDictData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long dictCode;

    /** 字典排序 */
    @Excel(name = "字典排序")
    private Long dictSort;

    /** 字典标签 */
    @Excel(name = "字典标签")
    private String dictLabel;

    /** 字典键值 */
    @Excel(name = "字典键值")
    private String dictValue;

    /** 字典类型 */
    @Excel(name = "字典类型")
    private String dictType;

    /** 样式属性（其他样式扩展） */
    @Excel(name = "样式属性", readConverterExp = "其=他样式扩展")
    private String cssClass;

    /** 表格回显样式 */
    @Excel(name = "表格回显样式")
    private String listClass;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 是否默认（1是 0否） */
    @Excel(name = "是否默认", readConverterExp = "1=是,0=否")
    private String defaultFlag;

    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    public Long getDictCode() {
        return dictCode;
    }

    public void setDictSort(Long dictSort) {
        this.dictSort = dictSort;
    }

    public Long getDictSort() {
        return dictSort;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public String getListClass() {
        return listClass;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public String getDefaultFlag() {
        return defaultFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("dictCode", getDictCode())
                .append("dictSort", getDictSort()).append("dictLabel", getDictLabel())
                .append("dictValue", getDictValue()).append("dictType", getDictType()).append("cssClass", getCssClass())
                .append("listClass", getListClass()).append("status", getStatus())
                .append("defaultFlag", getDefaultFlag()).append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy()).append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime()).append("remark", getRemark()).toString();
    }
}
