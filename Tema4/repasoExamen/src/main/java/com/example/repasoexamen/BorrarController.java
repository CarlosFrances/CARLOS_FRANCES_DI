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

public class BorrarController implements Initializable {

    @FXML
    private TextField textoBuscar;

    @FXML
    private Button botonBuscar;
    private MainController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage)botonBuscar.getScene().getWindow()).close();
                controller.recepcionBorrar(textoBuscar.getText());
            }
        });
    }

    public void setControladora(MainController controladora){
        controller=controladora;
    }
}
