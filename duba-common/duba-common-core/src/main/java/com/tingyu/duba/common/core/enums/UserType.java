package com.tingyu.duba.common.core.enums;

/**
 * 用户状态
 */
public enum UserType {
    ADMIN("admin", "超级管理员"), COMMON("common", "内部员工角色"), EXTERNAL("external", "外部用户角色");

    private final String code;
    private final String info;

    UserType(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
