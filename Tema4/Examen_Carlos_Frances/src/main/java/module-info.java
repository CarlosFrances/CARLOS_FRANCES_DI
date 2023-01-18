module com.example.examen_carlos_frances {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.json;

    opens com.example.examen_carlos_frances to javafx.fxml;
    opens com.example.examen_carlos_frances.model to javafx.fxml;
    exports com.example.examen_carlos_frances;
    exports com.example.examen_carlos_frances.model;
}