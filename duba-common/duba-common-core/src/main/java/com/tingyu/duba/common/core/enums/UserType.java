package com.tingyu.duba.common.core.enums;

/**
 * 用户状态
 */
public enum UserType {
    ADMIN("admin", "超级管理员"), COMMON("common", "普通用户");

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
