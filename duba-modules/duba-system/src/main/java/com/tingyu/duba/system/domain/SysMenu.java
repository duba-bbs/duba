package com.tingyu.duba.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tingyu.duba.common.core.annotation.Excel;
import com.tingyu.duba.common.core.web.domain.BaseEntity;

/**
 * 菜单权限对象 sys_menu
 */
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 菜单id */
    private Long menuId;

    /** 菜单名称 */
    @Excel(name = "菜单名称")
    private String menuName;

    /** 父菜单id */
    @Excel(name = "父菜单id")
    private Long parentId;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long orderNum;

    /** 路由地址 */
    @Excel(name = "路由地址")
    private String path;

    /** 组件路径 */
    @Excel(name = "组件路径")
    private String component;

    /** 是否为外链（y是 n否） */
    @Excel(name = "是否为外链", readConverterExp = "y=是,n=否")
    private String isFrame;

    /** 是否缓存（y缓存 n不缓存） */
    @Excel(name = "是否缓存", readConverterExp = "y=缓存,n=不缓存")
    private String isCache;

    /** 菜单类型（0目录 1菜单 2按钮） */
    @Excel(name = "菜单类型", readConverterExp = "0=目录,1=菜单,2=按钮")
    private String menuType;

    /** 菜单状态（0显示 1隐藏） */
    @Excel(name = "菜单状态", readConverterExp = "0=显示,1=隐藏")
    private String visible;

    /** 菜单状态（0正常 1停用） */
    @Excel(name = "菜单状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 权限标识 */
    @Excel(name = "权限标识")
    private String perms;

    /** 菜单图标 */
    @Excel(name = "菜单图标")
    private String icon;

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getComponent() {
        return component;
    }

    public void setIsFrame(String isFrame) {
        this.isFrame = isFrame;
    }

    public String getIsFrame() {
        return isFrame;
    }

    public void setIsCache(String isCache) {
        this.isCache = isCache;
    }

    public String getIsCache() {
        return isCache;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getVisible() {
        return visible;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getPerms() {
        return perms;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("menuId", getMenuId())
                .append("menuName", getMenuName()).append("parentId", getParentId()).append("orderNum", getOrderNum())
                .append("path", getPath()).append("component", getComponent()).append("isFrame", getIsFrame())
                .append("isCache", getIsCache()).append("menuType", getMenuType()).append("visible", getVisible())
                .append("status", getStatus()).append("perms", getPerms()).append("icon", getIcon())
                .append("createBy", getCreateBy()).append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("remark", getRemark()).toString();
    }
}
