package com.tingyu.duba.system.api.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 操作日志记录对象 sys_oper_log
 */
public class SysOperLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long operId;

    /** 模块标题 */
    @Excel(name = "模块标题")
    private String title;

    /** 操作类型（0其它 1新增 2修改 3删除） */
    @Excel(name = "操作类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除")
    private String operatorType;

    /** 方法名称 */
    @Excel(name = "方法名称")
    private String method;

    /** 请求方式 */
    @Excel(name = "请求方式")
    private String requestMethod;

    /** 操作来源（0其它 1后台用户 2手机端用户 3PC端用户） */
    @Excel(name = "操作来源", readConverterExp = "0=其它,1=后台用户,2=手机端用户,3=PC端用户")
    private String operatorSource;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operName;

    /** 请求url */
    @Excel(name = "请求url")
    private String operUrl;

    /** 主机地址 */
    @Excel(name = "主机地址")
    private String operIp;

    /** 操作地点 */
    @Excel(name = "操作地点")
    private String operLocation;

    /** 请求参数 */
    @Excel(name = "请求参数")
    private String operParam;

    /** 返回参数 */
    @Excel(name = "返回参数")
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    @Excel(name = "操作状态", readConverterExp = "0=正常,1=异常")
    private String status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    private String errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operTime;

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setOperatorSource(String operatorSource) {
        this.operatorSource = operatorSource;
    }

    public String getOperatorSource() {
        return operatorSource;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public Date getOperTime() {
        return operTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("operId", getOperId())
                .append("title", getTitle()).append("operatorType", getOperatorType()).append("method", getMethod())
                .append("requestMethod", getRequestMethod()).append("operatorSource", getOperatorSource())
                .append("operName", getOperName()).append("operUrl", getOperUrl()).append("operIp", getOperIp())
                .append("operLocation", getOperLocation()).append("operParam", getOperParam())
                .append("jsonResult", getJsonResult()).append("status", getStatus()).append("errorMsg", getErrorMsg())
                .append("operTime", getOperTime()).toString();
    }
}