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

public class Detalles implements Initializable {
    @FXML
    private Button botonVolver,botonCambiar;

    @FXML
    private Label labelApellido;

    @FXML
    private Label labelNombre;

    HelloController controller;
    SecondScene controller2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonVolver.setOnAction(new ManejoPulsaciones());
        botonCambiar.setOnAction(new ManejoPulsaciones());
        /*botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.recibirNombre(labelNombre.getText());
                ((Stage)labelApellido.getScene().getWindow()).close();
            }
        });
        botonCambiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("second-scene-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonVolver.getScene().getWidth(),botonVolver.getScene().getHeight());
                    Stage stage = (Stage)botonCambiar.getScene().getWindow();
                    stage.setScene(scene);
                    SecondScene controller = loader.getController();
                    controller.setApellido(labelApellido.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/
    }

    public void start(Persona persona) {
        labelNombre.setText(persona.getNombre());
        labelApellido.setText(persona.getApellido());
    }

    public void setController(HelloController controller){
        this.controller=controller;
    }

    public void setApellido(String text) {
        labelNombre.setText(text);
    }

    public void setControllerSecond(SecondScene secondScene) {
        this.controller2=secondScene;
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent a) {
            if(a.getSource() == botonVolver){
                controller.recibirNombre(labelNombre.getText());
                ((Stage)labelApellido.getScene().getWindow()).close();
            }else if(a.getSource() == botonCambiar){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("second-scene-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonVolver.getScene().getWidth(),botonVolver.getScene().getHeight());
                    Stage stage = (Stage)botonCambiar.getScene().getWindow();
                    stage.setScene(scene);
                    SecondScene controllerSecond = loader.getController();
                    controllerSecond.setController(Detalles.this);
                    controllerSecond.setControllerHello(controller);
                    controllerSecond.setApellido(labelApellido.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
