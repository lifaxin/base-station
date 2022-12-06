package com.lifaxin.bs.components.repositories;

import com.lifaxin.bs.Launcher;
import com.lifaxin.bs.controller.PluginItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

import java.io.IOException;

/**
 * @author FaXin.Li
 * @version v1.0
 * @description: 插件行
 * @date 2022/12/5 17:00
 */
public class PluginListCell extends ListCell<PluginEntity> {

    private Node graphic;
    private PluginItemController pluginItemController;
    public PluginListCell() {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("pluginItem.fxml"));
        try {
            graphic = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pluginItemController = fxmlLoader.getController();
    }

    @Override
    public void updateItem(PluginEntity item, boolean empty) {
        //更新listView对象的选项组件内容
        super.updateItem(item, empty);
        if (item != null) {
            setGraphic(graphic);
            pluginItemController.addData(item);
        }
    }


}
