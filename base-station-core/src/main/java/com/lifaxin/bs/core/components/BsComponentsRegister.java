package com.lifaxin.bs.core.components;

import javafx.scene.Scene;

import java.util.Objects;

/**
 * 组件注册器
 *
 * @author FaXin.Li
 * @date 2023/7/22 15:46
 */
public class BsComponentsRegister {

    public static void initComponents(Scene scene){
        // 加载样式表
        String stylesheets = Objects.requireNonNull(BsComponentsRegister.class.getResource("bs-components.css")).toExternalForm();
        scene.getStylesheets().add(stylesheets);
    }
}
