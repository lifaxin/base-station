package com.lifaxin.bs.controller;

import com.lifaxin.bs.context.ComponentContext;

/**
 * 主界面控制器
 *
 * @author FaXin.Li
 * @date 2023/3/22 14:43
 */
public class MainController {

    boolean iconified = false;
    boolean maximized = false;

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
}
