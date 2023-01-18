package com.example.repasoexamen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TelefonoController implements Initializable {

    @FXML
    private Button botonEnviar;

    @FXML
    private TextField textoTelefono;
    MainController controller;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage)botonEnviar.getScene().getWindow()).close();
                controller.recepcionTelefono(textoTelefono.getText());
            }
        });
    }

    public void setControladora(MainController controladora){
        controller=controladora;
    }
}
