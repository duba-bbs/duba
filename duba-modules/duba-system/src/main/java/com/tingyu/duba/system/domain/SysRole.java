package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

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

    /** 角色状态（0正常 1停用） */
    @Excel(name = "角色状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 逻辑删除（1代表已删除 0代表未删除） */
    private String delFlag;

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleSort(Long roleSort) {
        this.roleSort = roleSort;
    }

    public Long getRoleSort() {
        return roleSort;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getDataScope() {
        return dataScope;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("roleId", getRoleId())
                .append("roleName", getRoleName()).append("roleKey", getRoleKey()).append("roleSort", getRoleSort())
                .append("dataScope", getDataScope()).append("status", getStatus()).append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy()).append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime()).append("remark", getRemark()).append("delFlag", getDelFlag())
                .toString();
    }
}
