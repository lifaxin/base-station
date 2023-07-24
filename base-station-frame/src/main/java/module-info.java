module com.lifaxin.bs {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires javafx.fxml;
    requires javafx.base;

    // 工具类
    requires io.github.classgraph;
    requires com.alibaba.fastjson2;
    requires org.apache.commons.lang3;
    requires org.apache.commons.collections4;
    requires lombok;

    // 皮肤
    requires MaterialFX;
    requires com.lifaxin.bs.core;
    requires com.lifaxin.bs.plugin;
    
    
    opens com.lifaxin.bs to javafx.fxml;
    opens com.lifaxin.bs.controller to javafx.fxml;

    exports com.lifaxin.bs;
    exports com.lifaxin.bs.controller;
}