package com.tingyu.duba.common.log.enums;

/**
 * 操作状态
 *
 */
public enum OperStatus {

    SUCCESS("0", "成功"), FAIL("1", "失败");

    private final String code;
    private final String info;

    OperStatus(String code, String info) {
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
