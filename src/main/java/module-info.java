module com.lifaxin.bs {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lifaxin.bs to javafx.fxml;
    opens com.lifaxin.bs.controller to javafx.fxml;

    exports com.lifaxin.bs;
    exports com.lifaxin.bs.controller;
}