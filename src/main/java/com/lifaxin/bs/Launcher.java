package com.lifaxin.bs;

import com.lifaxin.bs.utils.AppUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Launcher extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        // 获取屏幕大小
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        // 初始化设置
        AppUtils.scene = new Scene(AppUtils.loadFXML("base"), screenWidth * 0.8, screenHeight * 0.8);
        AppUtils.stage = stage;
        AppUtils.stage.setScene(AppUtils.scene);
        // 开启页面
//        AppUtils.stage.initStyle(StageStyle.UNDECORATED);
        AppUtils.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}