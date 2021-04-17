package com.tingyu.duba.common.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.tingyu.duba.common.log.enums.OperSource;
import com.tingyu.duba.common.log.enums.OperType;

/**
 * 自定义操作日志记录注解
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public OperType operType() default OperType.OTHER;

    /**
     * 操作来源
     */
    public OperSource operSource() default OperSource.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
