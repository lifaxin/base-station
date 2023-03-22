module com.lifaxin.bs {
    requires javafx.controls;
    requires javafx.fxml;


    requires lombok;
    requires org.apache.commons.lang3;

    requires io.github.classgraph;
    requires org.reflections;
    requires org.apache.commons.io;
    requires com.alibaba.fastjson2;

    requires com.lifaxin.bs.plugin;

    opens com.lifaxin.bs to javafx.fxml;
    opens com.lifaxin.bs.controller to javafx.fxml;

    exports com.lifaxin.bs;
    exports com.lifaxin.bs.controller;
}