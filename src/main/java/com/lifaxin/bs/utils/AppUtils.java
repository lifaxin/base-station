package com.lifaxin.bs.utils;

import com.lifaxin.bs.Launcher;
import com.lifaxin.bs.context.ComponentContext;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @version 1.0
 * @description: APP工具类
 * @author: FaXin.Li
 * @date: 2022/8/20
 */
public class AppUtils {

    /**
     * 全局自定义场景
     */



    public static void forward(String fxml) {
        try {
            ComponentContext.scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void redirect(String fxml, String name, double screenWidth, double screenHeight, boolean resizable) {
        // 构建幕布
        Stage newStage = new Stage();
        newStage.setTitle(name);
        // 构建场景
        Scene newScene = null;
        try {
            newScene = new Scene(AppUtils.loadFXML(fxml), screenWidth * 0.8, screenHeight * 0.8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newStage.setScene(newScene);
        newStage.setResizable(resizable);
        newStage.show();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void minimize(){
        ComponentContext.stage.setIconified(true);
    }
}
