package com.lifaxin.bs.controller;

import com.lifaxin.bs.components.repositories.PluginEntity;
import com.lifaxin.bs.components.repositories.PluginListCell;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author FaXin.Li
 * @version v1.0
 * @description: 插件仓库列表
 * @date 2022/12/5 15:50
 */
public class RepositoryController implements Initializable {

    @FXML
    private ListView<PluginEntity> repositoryListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PluginEntity pluginEntity = new PluginEntity();
        pluginEntity.setName("CronTab 表达式设计器");
        pluginEntity.setDescription("拉希姆·斯特林（Raheem Sterling），1994年12月8日出生于牙买加金斯敦，拥有英国和牙买加双重国籍，英格兰足球运动员，场上司职边锋/前腰，曾效力于女王公园巡游者足球俱乐部、利物浦足球俱乐部和曼彻斯特城足球俱乐部 [1]  ，现效力于切尔西足球俱乐部 [46]  。");
        pluginEntity.setDownLoadUrl("aaa");
        pluginEntity.setIcon("E:\\source_workspace\\base-station\\src\\main\\resources\\images\\logo.png");
        pluginEntity.setWidth(repositoryListView.widthProperty());
        repositoryListView.setItems(FXCollections.observableArrayList(pluginEntity));
        repositoryListView.setCellFactory((ListView<PluginEntity> l) -> new PluginListCell());
    }
}
