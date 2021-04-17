package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 字典类型对象 sys_dict_type
 */
public class SysDictType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long dictId;

    /** 字典名称 */
    @Excel(name = "字典名称")
    private String dictName;

    /** 字典类型 */
    @Excel(name = "字典类型")
    private String dictType;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("dictId", getDictId())
                .append("dictName", getDictName()).append("dictType", getDictType()).append("status", getStatus())
                .append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("remark", getRemark()).toString();
    }
}
