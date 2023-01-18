module com.example.pokeapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.json;

    opens com.example.pokeapi to javafx.fxml;
    opens com.example.pokeapi.model to javafx.fxml;
    exports com.example.pokeapi;
    exports com.example.pokeapi.model;
}