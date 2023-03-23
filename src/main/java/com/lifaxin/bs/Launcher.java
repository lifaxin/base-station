package com.lifaxin.bs;

import com.lifaxin.bs.context.ComponentContext;
import com.lifaxin.bs.utils.AppUtils;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
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
        ComponentContext.scene = new Scene(AppUtils.loadFXML("main"), screenWidth * 0.8, screenHeight * 0.8);
        ComponentContext.stage = stage;
        ComponentContext.stage.setTitle("基站");
        ComponentContext.stage.setScene(ComponentContext.scene);
        // 开启页面
        ComponentContext.stage.initStyle(StageStyle.UNDECORATED);
        ComponentContext.stage.show();
        // 开启主题
        MFXThemeManager.addOn(ComponentContext.scene, Themes.DEFAULT, Themes.LEGACY);
        // 加载系统托盘处理









        // 加载插件
        String plugins = "E:\\personalspace\\demo\\target";
//        PluginLoadUtils.instance.loadPlugin(plugins);
    }

    public static void main(String[] args) {
        launch();
    }
}