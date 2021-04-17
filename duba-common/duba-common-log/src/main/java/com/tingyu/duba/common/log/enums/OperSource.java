package com.tingyu.duba.common.log.enums;

/**
 * 操作来源
 */
public enum OperSource {

    OTHER("0", "其它"), MANAGE("1", "后台用户"), MOBILE("2", "手机端用户"), PC("3", "PC用户");

    private final String code;
    private final String info;

    OperSource(String code, String info) {
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
