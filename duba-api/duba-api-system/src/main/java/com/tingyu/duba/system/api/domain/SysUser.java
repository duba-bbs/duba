package com.tingyu.duba.system.api.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.annotation.Excel.Type;
import com.tingyu.duba.common.core.annotation.Excels;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户信息对象 sys_user
 */
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long userId;

    /** 部门ID */
    @Excel(name = "部门编号", type = Type.IMPORT)
    private Long deptId;

    /** 登录账号 */
    @Excel(name = "登录账号")
    private String username;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 用户类型（0超级管理员 1普通用户） */
    @Excel(name = "用户类型", readConverterExp = "0=超级管理员,1=普通用户")
    private String userType;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 座右铭 */
    @Excel(name = "座右铭")
    private String motto;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 用户性别（0男 1女 2未知） */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 头像路径 */
    @Excel(name = "头像路径")
    private String avatar;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 最后更新密码时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后更新密码时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyPwdTime;

    /** 盐加密 */
    @Excel(name = "盐加密")
    private String salt;

    /** 帐号状态（0正常 1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginTime;

    /** 最后登录ip */
    @Excel(name = "最后登录ip")
    private String loginIp;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    /** 部门对象 */
    @Excels({ @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT) })
    private SysDept dept;

    /** 岗位组 */
    private Long[] positionIds;

    /** 角色对象 */
    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    public String getUsername() {
        return username;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    public String getNickName() {
        return nickName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail() {
        return email;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getMotto() {
        return motto;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setModifyPwdTime(Date modifyPwdTime) {
        this.modifyPwdTime = modifyPwdTime;
    }

    public Date getModifyPwdTime() {
        return modifyPwdTime;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public Long[] getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(Long[] positionIds) {
        this.positionIds = positionIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("userId", getUserId())
                .append("username", getUsername()).append("deptId", getDeptId()).append("nickName", getNickName())
                .append("userType", getUserType()).append("email", getEmail()).append("motto", getMotto())
                .append("phonenumber", getPhonenumber()).append("sex", getSex()).append("avatar", getAvatar())
                .append("password", getPassword()).append("modifyPwdTime", getModifyPwdTime()).append("salt", getSalt())
                .append("status", getStatus()).append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("loginTime", getLoginTime()).append("loginIp", getLoginIp()).append("remark", getRemark())
                .append("delFlag", getDelFlag()).append("dept", getDept()).toString();
    }
}