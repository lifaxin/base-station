package com.lifaxin.bs.controller;

import com.lifaxin.bs.context.ComponentContext;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * 主界面控制器
 *
 * @author FaXin.Li
 * @date 2023/3/22 14:43
 */
public class MainController {

    boolean iconified = false;
    boolean maximized = false;

    private double xOffset = 0;
    private double yOffset = 0;


    public void close(){
        System.exit(0);
    }

    public void min(){
        iconified = iconified ? false : true;
        ComponentContext.stage.setIconified(iconified);
    }

    public void max(){
        maximized = maximized ? false : true;
        ComponentContext.stage.setMaximized(maximized);

    }


    public void getDragLocation(MouseEvent event){
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    public void setDragLocation(MouseEvent event){
        ComponentContext.stage.setX(event.getScreenX() - xOffset);
        ComponentContext.stage.setY(event.getScreenY() - yOffset);
    }
}
