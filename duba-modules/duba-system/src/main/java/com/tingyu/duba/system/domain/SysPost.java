package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 贴子对象 sys_post
 */
public class SysPost extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long postId;

    /** 所属吧 */
    @Excel(name = "所属吧")
    private Long barId;

    /** 贴子标题 */
    @Excel(name = "贴子标题")
    private String title;

    /** 贴子内容 */
    @Excel(name = "贴子内容")
    private String content;

    /** 发帖人id */
    @Excel(name = "发帖人id")
    private Long userId;

    /** 阅读量 */
    @Excel(name = "阅读量")
    private Long viewTimes;

    /** 贴子状态（0正常 1停用） */
    @Excel(name = "贴子状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 是否精品（1是 0否） */
    @Excel(name = "是否精品", readConverterExp = "1=是,0=否")
    private String topQuality;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public Long getBarId() {
        return barId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setViewTimes(Long viewTimes) {
        this.viewTimes = viewTimes;
    }

    public Long getViewTimes() {
        return viewTimes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTopQuality(String topQuality) {
        this.topQuality = topQuality;
    }

    public String getTopQuality() {
        return topQuality;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("postId", getPostId())
                .append("barId", getBarId()).append("title", getTitle()).append("content", getContent())
                .append("userId", getUserId()).append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("viewTimes", getViewTimes()).append("status", getStatus()).append("remark", getRemark())
                .append("topQuality", getTopQuality()).append("delFlag", getDelFlag()).toString();
    }
}
