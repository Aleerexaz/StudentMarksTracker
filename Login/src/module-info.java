module org.example.login {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires  java.sql;

    opens org.example.login to javafx.fxml;
    exports org.example.login;
}