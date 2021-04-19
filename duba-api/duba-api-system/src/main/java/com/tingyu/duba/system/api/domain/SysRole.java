package com.tingyu.duba.system.api.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户信息对象 sys_role
 */
public class SysRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long roleId;

    /** 角色名称 */
    @Excel(name = "角色名称")
    private String roleName;

    /** 角色权限字符串 */
    @Excel(name = "角色权限字符串")
    private String roleKey;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long roleSort;

    /** 数据范围（1全部数据权限 2自定数据权限 3：本部门数据权限 4：本部门及以下数据权限） */
    @Excel(name = "数据范围", readConverterExp = "1=全部数据权限,2=自定数据权限,3=：本部门数据权限,4=：本部门及以下数据权限")
    private String dataScope;

    /** 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示） */
    private boolean menuCheckStrictly;

    /** 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ） */
    private boolean deptCheckStrictly;

    /** 角色状态（0正常 1停用） */
    @Excel(name = "角色状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    /** 菜单组 */
    private Long[] menuIds;

    public SysRole() {

    }

    public SysRole(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @NotBlank(message = "角色名称不能为空")
    @Size(min = 0, max = 30, message = "角色名称长度不能超过30个字符")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    @NotBlank(message = "权限字符不能为空")
    @Size(min = 0, max = 100, message = "权限字符长度不能超过100个字符")
    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleSort(Long roleSort) {
        this.roleSort = roleSort;
    }

    @NotBlank(message = "显示顺序不能为空")
    public Long getRoleSort() {
        return roleSort;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getDataScope() {
        return dataScope;
    }

    public boolean isMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    public void setMenuCheckStrictly(boolean menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public boolean isDeptCheckStrictly() {
        return deptCheckStrictly;
    }

    public void setDeptCheckStrictly(boolean deptCheckStrictly) {
        this.deptCheckStrictly = deptCheckStrictly;
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

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("roleId", getRoleId())
                .append("roleName", getRoleName()).append("roleKey", getRoleKey()).append("roleSort", getRoleSort())
                .append("dataScope", getDataScope()).append("menuCheckStrictly", isMenuCheckStrictly())
                .append("deptCheckStrictly", isDeptCheckStrictly()).append("status", getStatus())
                .append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("remark", getRemark()).append("delFlag", getDelFlag()).toString();
    }
}
