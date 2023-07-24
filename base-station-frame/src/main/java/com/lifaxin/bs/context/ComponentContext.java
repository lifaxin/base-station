package com.lifaxin.bs.context;

import com.lifaxin.bs.domain.PluginEntity;
import com.lifaxin.bs.plugin.PluginService;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

/**
 * 组件上下文
 *
 * @author FaXin.Li
 * @date 2023/3/15 9:58
 */
public class ComponentContext {

    private static Scene scene;
    private static Stage stage;
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ComponentContext.stage = stage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        ComponentContext.scene = scene;
    }

}
