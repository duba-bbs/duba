package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 吧对象 sys_bar
 */
public class SysBar extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long barId;

    /** 上级id，级别是版时为0 */
    @Excel(name = "上级id，级别是版时为0")
    private Long parentId;

    /** 类型（0版 1吧） */
    @Excel(name = "类型", readConverterExp = "0=版,1=吧")
    private String barType;

    /** 吧名称 */
    @Excel(name = "吧名称")
    private String barName;

    /** 吧描述 */
    @Excel(name = "吧描述")
    private String description;

    /** 吧状态（0正常 1停用） */
    @Excel(name = "吧状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public Long getBarId() {
        return barId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setBarType(String barType) {
        this.barType = barType;
    }

    public String getBarType() {
        return barType;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getBarName() {
        return barName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("barId", getBarId())
                .append("parentId", getParentId()).append("barType", getBarType()).append("barName", getBarName())
                .append("description", getDescription()).append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy()).append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime()).append("status", getStatus()).append("remark", getRemark())
                .append("delFlag", getDelFlag()).toString();
    }
}
