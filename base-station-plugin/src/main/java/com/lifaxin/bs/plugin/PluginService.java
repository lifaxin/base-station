package com.lifaxin.bs.plugin;

import javafx.stage.Stage;

/**
 * 插件服务
 *
 * @author FaXin.Li
 * @date 2023/7/19 14:08
 */
public interface PluginService {
    String getCategory();

    String getName();

    String getVersion();

    String getLocation();
}
