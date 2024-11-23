module org.main.yetanothermessagerapp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens main.app.ui to javafx.fxml;
    exports main.app.ui;
}