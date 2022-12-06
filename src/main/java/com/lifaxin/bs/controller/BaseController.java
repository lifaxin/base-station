package com.lifaxin.bs.controller;

import com.lifaxin.bs.utils.AppUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;

/**
 * @author FaXin.Li
 * @version 1.0
 * @description: 基础页面
 * @date 2022/12/5 13:33
 */
public class BaseController {
    @FXML
    private TabPane myPluginsTabPane;


    /**
     * 调起 插件库
     *
     * @param mouseEvent
     */
    public void listRepository(MouseEvent mouseEvent) {
        // 获取屏幕大小
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        // 切换页面
        AppUtils.redirect("repository", "插件库", screenWidth * 0.7, screenHeight * 0.7, Boolean.FALSE);
    }

    /**
     * 我的插件
     *
     * @param mouseEvent
     */
    public void selectMyPlugins(MouseEvent mouseEvent) {
        Tab myPluginTab = myPluginsTabPane.getTabs().get(0);
        myPluginsTabPane.getSelectionModel().select(myPluginTab);
    }
}
