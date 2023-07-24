package com.lifaxin.bs.domain;

import com.lifaxin.bs.plugin.PluginService;
import lombok.*;

import java.net.URLClassLoader;

/**
 * 插件信息实体类
 *
 * @author FaXin.Li
 * @date 2023/7/19 16:24
 */
public class PluginEntity {

    /**
     * 类加载器
     */
    private URLClassLoader classLoader;

    /**
     * 插件类入口
     */
    private PluginService pluginService;

    public URLClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(URLClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public PluginService getPluginService() {
        return pluginService;
    }

    public void setPluginService(PluginService pluginService) {
        this.pluginService = pluginService;
    }

    public PluginEntity(URLClassLoader classLoader, PluginService pluginService) {
        this.classLoader = classLoader;
        this.pluginService = pluginService;
    }
}
