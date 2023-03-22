package com.lifaxin.bs.controller;

import com.lifaxin.bs.utils.AppUtils;
import com.lifaxin.bs.utils.ResourceUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

/**
 * @author FaXin.Li
 * @version 1.0
 * @description: 基础页面
 * @date 2022/12/5 13:33
 */
public class BaseController implements Initializable {
    @FXML
    private HBox topMenu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 加载菜单
        addTopMenu(topMenu, "插件库", "menu/PluginRepository.png", "", action -> { });
        addTopMenu(topMenu, "提交插件", "menu/AddPlugin.png", "", action -> { });
        // 加载工具类

    }



    /**
     * 添加菜单
     *
     * @param menu
     * @param name
     * @param image
     * @param action
     * @param consumer
     * @return
     */
    public VBox addTopMenu(HBox menu, String name, String image, String action, Consumer<String> consumer) {
        VBox vBox = new VBox();
        vBox.getStyleClass().add("topMenuItem");
        // 设置大小
        vBox.setPrefWidth(60.0d);
        vBox.setPrefHeight(60.0d);
        // 设置位置
        vBox.setAlignment(Pos.CENTER);
        // 设置点击事件
        vBox.setOnMouseClicked(mouseEvent -> {

        });

        // 按钮图片
        ImageView btnImage = new ImageView(new Image(ResourceUtils.instance.getImage(image)));
        btnImage.setFitHeight(32.0d);
        btnImage.setFitWidth(32.0d);
        // 图片值
        Label btnText = new Label(name);
        vBox.setMargin(btnImage, new Insets(0, 5, 0, 0));
        vBox.setMargin(btnText, new Insets(0, 5, 0, 0));
        vBox.getChildren().addAll(btnImage, btnText);
        //@NamedArg("top") @NamedArg("right") @NamedArg("bottom") @NamedArg("left")
        topMenu.setMargin(vBox, new Insets(5, 10, 5, 0));
        topMenu.getChildren().add(vBox);
        return vBox;
    }

}
