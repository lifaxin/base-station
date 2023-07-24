package com.lifaxin.bs.core.components;

import com.lifaxin.bs.core.utils.StageChangeUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.skin.TitledPaneSkin;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.function.Consumer;

/**
 * 基站组件-手风琴菜单-项
 *
 * @author FaXin.Li
 * @date 2023/7/22 15:41
 */
public class BsAccordionMenuItem extends TitledPane {

    public BsAccordionMenuItem(String title, List<BsAccordionMenu.MenuItemData> menuItemDataList, boolean expanded, Consumer<Node> showEvent) {
        setBorder(Border.EMPTY);
        setText(title);
        expandedProperty().set(expanded);
        animatedProperty().set(true);
        // 设置样式类以应用 CSS 样式
        getStyleClass().add("bs-menu-item");
        // 内容
        VBox content = new VBox();
        content.getStyleClass().add("bs-menu-item-content");
        content.setBorder(Border.EMPTY);
        content.setSpacing(10.0d);
        content.setAlignment(Pos.CENTER);

        setContent(content);
        // 添加事件处理，当折叠状态改变时，显示或隐藏内容
        expandedProperty().addListener((observable, oldValue, newValue) -> {
            content.setVisible(newValue);
            content.setManaged(newValue);
        });
        menuItemDataList.forEach(menuItemData -> {
            Label menuItem = new Label(menuItemData.getName());
            menuItem.setPrefWidth(200d);
            menuItem.setAlignment(Pos.CENTER);
            menuItem.getStyleClass().add("bs-menu-item-btn");
            menuItem.setPadding(new Insets(5,0,5,0));
            menuItem.setOnMouseClicked(event -> {
                onClicked(menuItemData, showEvent);
            });
            VBox.setVgrow(menuItem, Priority.ALWAYS);
            content.getChildren().add(menuItem);
        });
    }


    private void onClicked(BsAccordionMenu.MenuItemData menuItemData, Consumer<Node> showEvent) {
        Node node = StageChangeUtils.INSTANCE.load(menuItemData.getClassLoader(), menuItemData.getTargetClass(), menuItemData.getAction());
        showEvent.accept(node);
    }
}
