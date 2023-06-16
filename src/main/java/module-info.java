module com.example.testapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.auth.oauth2;
    requires firebase.admin;

    opens com.example.testapp to javafx.fxml;
    exports com.example.testapp;
}