package com.lifaxin.bs.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常错误信息
 *
 * @author FaXin.Li
 * @date 2023/3/17 13:42
 */
@Getter
@AllArgsConstructor
public enum ExceptionCodeEnum {

    JAR_LOAD_EXCEPTION("0001", "Jar文件不存在"),
    CLASS_LOAD_EXCEPTION("0002", "类加载失败"),

    ;



    private String code;
    private String message;
}
