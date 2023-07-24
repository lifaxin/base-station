package com.lifaxin.bs.core.exception;

/**
 * 异常错误信息
 *
 * @author FaXin.Li
 * @date 2023/3/17 13:42
 */
public enum ExceptionCodeEnum {

    JAR_LOAD_EXCEPTION("0001", "Jar文件不存在"),
    CLASS_LOAD_EXCEPTION("0002", "类加载失败"),
    ;


    private String code;
    private String message;

    ExceptionCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
