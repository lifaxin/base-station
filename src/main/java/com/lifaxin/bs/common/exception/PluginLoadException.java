package com.lifaxin.bs.common.exception;

/**
 * 插件加载错误异常类
 *
 * @author FaXin.Li
 * @date 2023/3/17 13:41
 */
public class PluginLoadException extends RuntimeException{

    public PluginLoadException(ExceptionCodeEnum exceptionCode) {
        super(String.format("错误码：%s, 错误信息：%s", exceptionCode.getCode(), exceptionCode.getMessage()));
    }
}
