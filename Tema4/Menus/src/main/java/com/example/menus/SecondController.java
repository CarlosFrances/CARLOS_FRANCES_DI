package com.example.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private Label labelStage2;
    @FXML
    private Button botonResponder;

    @FXML
    private TextField textFieldStage2;
    private PrincipalController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonResponder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Cierre y que pase los datos a la controladora que ha llamado

                //Cerrar la ventana que ha llamado
                ((Stage)botonResponder.getScene().getWindow()).close();
                controller.recepcionRespuesta(textFieldStage2.getText());
                // Ejecutando un método en el origen
                // Acceder a la controladora

            }
        });
    }

    public void setControladora(PrincipalController controladora){
        this.controller = controladora;
        botonResponder.setDisable(false);
    }
    public void comunicarDatos(String texto){
        labelStage2.setText(texto);
        botonResponder.setDisable(true);
    }
}
