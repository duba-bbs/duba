package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 通知公告对象 sys_notice
 */
public class SysNotice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long noticeId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String noticeTitle;

    /** 公告类型（0通知 1公告） */
    @Excel(name = "公告类型", readConverterExp = "0=通知,1=公告")
    private String noticeType;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String noticeContent;

    /** 公告状态（0正常 1关闭） */
    @Excel(name = "公告状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("noticeId", getNoticeId())
                .append("noticeTitle", getNoticeTitle()).append("noticeType", getNoticeType())
                .append("noticeContent", getNoticeContent()).append("status", getStatus())
                .append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("remark", getRemark()).toString();
    }
}
