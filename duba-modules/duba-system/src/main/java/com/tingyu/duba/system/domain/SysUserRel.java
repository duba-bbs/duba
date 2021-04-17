package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 用户关系对象 sys_user_rel
 */
public class SysUserRel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long fromId;

    /** 目标id */
    @Excel(name = "目标id")
    private Long toId;

    /** 关系类型（0关注 1拉黑） */
    @Excel(name = "关系类型", readConverterExp = "0=关注,1=拉黑")
    private String relType;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public Long getToId() {
        return toId;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

    public String getRelType() {
        return relType;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
                .append("fromId", getFromId()).append("toId", getToId()).append("relType", getRelType())
                .append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag()).toString();
    }
}
