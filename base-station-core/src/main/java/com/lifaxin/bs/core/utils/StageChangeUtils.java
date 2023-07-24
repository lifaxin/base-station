package com.lifaxin.bs.core.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * 场景切换工具
 *
 * @author FaXin.Li
 * @date 2023/7/19 14:35
 */
public class StageChangeUtils {

    public static StageChangeUtils INSTANCE = new StageChangeUtils();

    public Node load(ClassLoader loader, Class<?> clazz, String name) {
        FXMLLoader fxmlLoader = new FXMLLoader(clazz.getResource(name));
        fxmlLoader.setClassLoader(loader);
        Parent node = null;
        try {
            node = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

}
