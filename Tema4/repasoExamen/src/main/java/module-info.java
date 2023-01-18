module com.example.repasoexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.repasoexamen to javafx.fxml;
    opens com.example.repasoexamen.model to javafx.fxml;
    exports com.example.repasoexamen;
    exports com.example.repasoexamen.model;
}