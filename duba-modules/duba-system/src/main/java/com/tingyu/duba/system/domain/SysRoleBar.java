package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 角色和吧关联对象 sys_role_bar
 */
public class SysRoleBar extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 角色id */
    @Excel(name = "角色id")
    private Long roleId;

    /** 吧id */
    @Excel(name = "吧id")
    private Long barId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public Long getBarId() {
        return barId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
                .append("roleId", getRoleId()).append("barId", getBarId()).toString();
    }
}
