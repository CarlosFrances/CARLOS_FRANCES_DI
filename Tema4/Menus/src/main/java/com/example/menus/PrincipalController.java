package com.example.menus;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    @FXML
    private MenuItem menuBidireccional;

    @FXML
    private MenuItem menuCerrar;

    @FXML
    private MenuItem menuEscena;

    @FXML
    private RadioMenuItem menuRadio1;

    @FXML
    private RadioMenuItem menuRadio2;

    @FXML
    private RadioMenuItem menuRadio3;
    private ToggleGroup grupoMenuRadios;

    @FXML
    private MenuItem menuUnidireccional;

    @FXML
    private TextField textFieldScene1;

    @FXML
    private Label labelScene1;

    @FXML
    private Button botonScene,botonStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();

    }

    public void comunicarTexto(String texto){
        labelScene1.setText(texto);
    }

    private void initGUI() {
        menuCerrar. setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exit.png"))));
    }

    private void instancias() {
        grupoMenuRadios=new ToggleGroup();
        grupoMenuRadios.getToggles().addAll(menuRadio1,menuRadio2,menuRadio3);
    }

    private void acciones() {
        menuBidireccional.setOnAction(new ManejoPulsaciones());

        menuUnidireccional.setOnAction(new ManejoPulsaciones());
        botonStage.setOnAction(new ManejoPulsaciones());

        menuEscena.setOnAction(new ManejoPulsaciones());
        botonScene.setOnAction(new ManejoPulsaciones());

        grupoMenuRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

                System.out.println(((RadioMenuItem)t1).getText());
            }
        });

        menuCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public void recepcionRespuesta(String text){
        labelScene1.setText(text);
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent a) {
            if(a.getSource() == botonScene || a.getSource() == menuEscena){
                // Cargar el fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("scene-view.fxml"));
                try {
                    Parent root = loader.load();
                    // Crear nueva escena y asignarle el mismo tamaño que la anterior
                    Scene scene = new Scene(root,botonScene.getScene().getWidth(),botonScene.getScene().getHeight());
                    // Poner la escena en el stage
                    Stage stage = (Stage) botonScene.getScene().getWindow();
                    stage.setScene(scene);
                    // pasar texto de escena a escena
                    SceneController controladora = loader.getController();
                    controladora.comunicarTexto(textFieldScene1.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else if(a.getSource() == botonStage || a.getSource() == menuUnidireccional){
                // Cargar FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("second-view.fxml"));
                // Crear escena
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,600,400);
                    // Crear stage
                    Stage stage = new Stage();

                    // Poner escena en stage
                    stage.setScene(scene);
                    SecondController controller = loader.getController();
                    controller.comunicarDatos(textFieldScene1.getText());
                    stage.setTitle("Ventana secundaria");
                    // Hacer visible stage
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else if(a.getSource() == menuBidireccional){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("second-view.fxml"));
                // Crear escena
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,600,400);
                    // Crear stage
                    Stage stage = new Stage();

                    // Poner escena en stage
                    stage.setScene(scene);
                    SecondController controller = loader.getController();
                    controller.comunicarDatos(textFieldScene1.getText());
                    //pasar la controladora
                    controller.setControladora(PrincipalController.this);
                    stage.setTitle("Ventana secundaria");
                    // Hacer visible stage
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
