package com.example.prexamen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondScene implements Initializable {

    @FXML
    private Button botonCambiar;

    @FXML
    private Label labelApellido;

    Detalles controller;
    HelloController controllerHello;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonCambiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("detalles-view.fxml"));
                try {
                    Parent root=loader.load();
                    Scene scene = new Scene(root,botonCambiar.getScene().getWidth(),botonCambiar.getScene().getHeight());
                    Stage stage = (Stage)botonCambiar.getScene().getWindow();
                    stage.setScene(scene);
                    Detalles controller= loader.getController();
                    controller.setControllerSecond(SecondScene.this);
                    controller.setController(controllerHello);
                    controller.setApellido(labelApellido.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void setApellido(String text) {
        labelApellido.setText(text);
    }

    public void setController(Detalles detalles) {
        this.controller=detalles;
    }

    public void setControllerHello(HelloController controller) {
        this.controllerHello=controller;
    }
}
