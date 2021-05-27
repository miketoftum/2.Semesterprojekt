module com.manhpd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires mongo.java.driver;
    requires java.logging;

    opens com.manhpd to javafx.fxml;
    exports com.manhpd;
}