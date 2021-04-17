package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 收藏对象 sys_favor
 */
public class SysFavor extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long favorId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 收藏实体id */
    @Excel(name = "收藏实体id")
    private Long favorTargetId;

    /** 收藏实体类型（0吧 1贴子） */
    @Excel(name = "收藏实体类型", readConverterExp = "0=吧,1=贴子")
    private String favorTargetType;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    public void setFavorId(Long favorId) {
        this.favorId = favorId;
    }

    public Long getFavorId() {
        return favorId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFavorTargetId(Long favorTargetId) {
        this.favorTargetId = favorTargetId;
    }

    public Long getFavorTargetId() {
        return favorTargetId;
    }

    public void setFavorTargetType(String favorTargetType) {
        this.favorTargetType = favorTargetType;
    }

    public String getFavorTargetType() {
        return favorTargetType;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("favorId", getFavorId())
                .append("userId", getUserId()).append("favorTargetId", getFavorTargetId())
                .append("favorTargetType", getFavorTargetType()).append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy()).append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime()).append("delFlag", getDelFlag()).toString();
    }
}
