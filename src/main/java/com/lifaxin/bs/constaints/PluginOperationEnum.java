package com.lifaxin.bs.constaints;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author FaXin.Li
 * @version v1.0
 * @description: 插件列表按钮工具
 * @date 2022/12/6 14:06
 */

public enum PluginOperationEnum {

    INSTALL("安装", args -> {

    }),
    UNINSTALL("删除", args -> {

    }),
    ;

    PluginOperationEnum(String showName, Consumer consumer) {
        this.showName = showName;
        this.consumer = consumer;
    }

    private String showName;

    public Consumer consumer;

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
