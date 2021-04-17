package com.tingyu.duba.common.log.enums;

/**
 * 业务操作类型
 */
public enum OperType {

    OTHER("0", "其它"), INSERT("1", "新增"), UPDATE("2", "修改"), DELETE("3", "删除"),

    GRANT("4", "授权"), EXPORT("5", "导出"), IMPORT("6", "导入"), FORCE("7", "强退"), GENCODE("8", "生成代码"), CLEAN("9", "清空数据");

    private final String code;
    private final String info;

    OperType(String code, String info) {
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
