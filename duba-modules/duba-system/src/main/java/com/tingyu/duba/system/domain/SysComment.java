package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 评论对象 sys_comment
 */
public class SysComment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long commentId;

    /** 所属贴 */
    @Excel(name = "所属贴")
    private Long postId;

    /** 上级评论，如果是0表示主楼 */
    @Excel(name = "上级评论，如果是0表示主楼")
    private Long parentId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 评论者id */
    @Excel(name = "评论者id")
    private Long userId;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long likes;

    /** 评论状态（0正常 1停用） */
    @Excel(name = "评论状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
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

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getLikes() {
        return likes;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("commentId", getCommentId())
                .append("postId", getPostId()).append("parentId", getParentId()).append("content", getContent())
                .append("userId", getUserId()).append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime()).append("likes", getLikes())
                .append("status", getStatus()).append("remark", getRemark()).append("delFlag", getDelFlag()).toString();
    }
}
