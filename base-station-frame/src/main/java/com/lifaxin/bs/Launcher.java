package com.lifaxin.bs;

import com.lifaxin.bs.context.ComponentContext;
import com.lifaxin.bs.core.components.BsComponentsRegister;
import com.lifaxin.bs.utils.AppUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Launcher extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // 获取屏幕大小
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        // 初始化设置
        ComponentContext.setScene(new Scene(AppUtils.loadFXML("main"), screenWidth * 0.8, screenHeight * 0.8));
        // 加载自定义组件
        BsComponentsRegister.initComponents(ComponentContext.getScene());
        // 初始化窗口设置
        ComponentContext.setStage(stage);
        Image image = new Image(Objects.requireNonNull(Launcher.class.getResourceAsStream("images/logo/logo.png")));
        ComponentContext.getStage().setTitle("基站");
        ComponentContext.getStage().getIcons().add(image);
        ComponentContext.getStage().setScene(ComponentContext.getScene());
        ComponentContext.getStage().show();
    }
}