package com.lifaxin.bs.components.repositories;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

/**
 * @author FaXin.Li
 * @version v1.0
 * @description: 插件列表项
 * @date 2022/12/5 16:56
 */
public class PluginEntity {

    /**
     * 插件名称
     */
    private String name;

    /**
     * 插件描述
     */
    private String description;

    /**
     * 下载地址
     */
    private String downLoadUrl;

    /**
     * 插件ICON
     */
    private String icon;

    private ReadOnlyDoubleProperty width;

    public PluginEntity(String name, String description, String downLoadUrl, String icon) {
        this.name = name;
        this.description = description;
        this.downLoadUrl = downLoadUrl;
        this.icon = icon;
    }

    public PluginEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setWidth(ReadOnlyDoubleProperty width) {
        this.width = width;
    }

    public ReadOnlyDoubleProperty getWidth() {
        return width;
    }

    public ReadOnlyDoubleProperty widthProperty() {
        return width;
    }
}
