package com.example.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

    @FXML
    private Button botonVolver;

    @FXML
    private Label labelScene2;

    @FXML
    private TextField textoScene2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    public void comunicarTexto(String texto){
        labelScene2.setText(texto);
    }

    private void instancias() {

    }

    private void acciones() {
        botonVolver.setOnAction(new ManejoPulsaciones());
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent a) {
            if(a.getSource() == botonVolver){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("principal-view.fxml"));
                try {
                    Parent root = loader.load();
                    // Crear nueva escena
                    Scene scene = new Scene(root,botonVolver.getScene().getWidth(),botonVolver.getScene().getHeight());
                    // Poner la escena en el stage
                    Stage stage = (Stage) botonVolver.getScene().getWindow();
                    stage.setScene(scene);
                    // pasar texto de escena a escena
                    PrincipalController controladora = loader.getController();
                    controladora.comunicarTexto(textoScene2.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
