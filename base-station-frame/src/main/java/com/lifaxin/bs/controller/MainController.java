package com.lifaxin.bs.controller;

import com.lifaxin.bs.common.constaints.FrameConstants;
import com.lifaxin.bs.core.components.BsAccordionMenu;
import com.lifaxin.bs.domain.PluginEntity;
import com.lifaxin.bs.utils.PluginLoadUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 主界面控制器
 *
 * @author FaXin.Li
 * @date 2023/3/22 14:43
 */
public class MainController implements Initializable {

    @FXML private VBox accordionContainer;
    @FXML private VBox contentContainer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 处理菜单插件列表
        List<PluginEntity> pluginList = PluginLoadUtils.instance.loadAllJarPlugin(FrameConstants.PLUGIN_HOME);
        List<BsAccordionMenu.MenuItemData> menuItemDataList = pluginList.stream().map(pluginEntity -> {
            BsAccordionMenu.MenuItemData menuItemData = new BsAccordionMenu.MenuItemData();
            menuItemData.setId(pluginEntity.getPluginService().getName());
            menuItemData.setName(pluginEntity.getPluginService().getName());
            menuItemData.setCategoryId(pluginEntity.getPluginService().getCategory());
            menuItemData.setCategory(pluginEntity.getPluginService().getCategory());
            menuItemData.setClassLoader(pluginEntity.getClassLoader());
            menuItemData.setTargetClass(pluginEntity.getPluginService().getClass());
            menuItemData.setAction(pluginEntity.getPluginService().getLocation());
            return menuItemData;
        }).toList();
        // 菜单点击事件处理
        BsAccordionMenu accordionMenu = new BsAccordionMenu(menuItemDataList, node -> {
            contentContainer.getChildren().clear();
            contentContainer.getChildren().add(node);
        });
        // 渲染菜单到主页面
        accordionContainer.getChildren().add(accordionMenu);
    }
}