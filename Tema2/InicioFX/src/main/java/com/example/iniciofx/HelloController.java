package com.example.iniciofx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button botonInicial,botonInicialDos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonInicial.setOnAction(new ManejoPulsaciones());
        botonInicialDos.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource()==botonInicial){
                welcomeText.setText("Boton uno pulsado");
            }else if(actionEvent.getSource()==botonInicialDos){
                welcomeText.setText("Boton dos pulsado");
            }
        }
    }
}