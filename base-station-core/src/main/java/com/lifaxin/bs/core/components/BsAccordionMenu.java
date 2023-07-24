package com.lifaxin.bs.core.components;

import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 基站组件-手风琴菜单
 *
 * @author FaXin.Li
 * @date 2023/7/22 15:28
 */
public class BsAccordionMenu extends VBox {

    public BsAccordionMenu(List<MenuItemData> menuItemDataList, Consumer<Node> showEvent) {
        // 去掉边框
        setBorder(Border.EMPTY);
        // 设置样式类以应用 CSS 样式
        getStyleClass().add("bs-accordion");
        // 解析菜单数据
        Map<String, List<MenuItemData>> menuMap = menuItemDataList.stream().collect(Collectors.groupingBy(MenuItemData::getCategoryId));
        boolean expanded = true;
        for (Map.Entry<String, List<MenuItemData>> menu : menuMap.entrySet()) {
            BsAccordionMenuItem item = new BsAccordionMenuItem(menu.getKey(), menu.getValue(), expanded, showEvent);
            getChildren().add(item);
            expanded = false;
        }

    }

    public static class MenuItemData{
        private String id;
        private String name;
        private String categoryId;
        private String category;
        private ClassLoader classLoader;
        private Class<?> targetClass;
        private String action;

        public MenuItemData() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public Class<?> getTargetClass() {
            return targetClass;
        }

        public void setTargetClass(Class<?> targetClass) {
            this.targetClass = targetClass;
        }

        public ClassLoader getClassLoader() {
            return classLoader;
        }

        public void setClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }
    }
}
