package com.lifaxin.bs.controller;

import com.lifaxin.bs.components.repositories.PluginEntity;
import com.lifaxin.bs.constaints.PluginOperationEnum;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author FaXin.Li
 * @description:
 * @date 2022/12/6 13:10
 */
public class PluginItemController {
    @FXML
    public ImageView image;
    @FXML
    public Label nameLabel;
    @FXML
    public Label describeLabel;
    @FXML
    public Button operationBtn;
    @FXML
    public VBox pluginDescBox;
    @FXML
    public HBox pluginItemBox;

    public void addData(PluginEntity pluginEntity) {
        image.setImage(new Image(pluginEntity.getIcon()));
        nameLabel.setText(pluginEntity.getName());
        describeLabel.setText(pluginEntity.getDescription());
        // 设置按钮操作
        operationBtn.setText(PluginOperationEnum.INSTALL.getShowName());
        operationBtn.setUserData(PluginOperationEnum.INSTALL);
        // 设置窗口UI
        pluginDescBox.setMinWidth(pluginEntity.getWidth().get() - 190);
        describeLabel.setMinWidth(pluginEntity.getWidth().get() - 190);
        nameLabel.setMinWidth(pluginEntity.getWidth().get() - 190);
        pluginItemBox.setMinWidth(pluginEntity.getWidth().get() - 20);
    }

    public void doOperation() {
        PluginOperationEnum pluginOperationEnum = (PluginOperationEnum) operationBtn.getUserData();
        pluginOperationEnum.getConsumer().accept("");
    }

}
