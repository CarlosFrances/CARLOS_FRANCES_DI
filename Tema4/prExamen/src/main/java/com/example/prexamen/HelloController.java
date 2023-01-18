package com.example.prexamen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HelloController implements Initializable {
    @FXML
    private TableColumn columnaApellido;

    @FXML
    private TableColumn columnaNombre;

    @FXML
    private Label labelRecepcion;

    @FXML
    private BorderPane panelGeneral;

    @FXML
    private TableView<Persona> tabla;
    private ObservableList<Persona> oTabla;
    private FilteredList<Persona> filtroTabla;

    @FXML
    private TextField textoBuscar;

    Detalles controller;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        textoBuscar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                filtroTabla.setPredicate(new Predicate<Persona>() {
                    @Override
                    public boolean test(Persona persona) {
                        return persona.getNombre().toLowerCase().contains(t1.toLowerCase());
                    }
                });
            }
        });
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observableValue, Persona persona, Persona t1) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("detalles-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,tabla.getScene().getWidth(),tabla.getScene().getHeight());
                    Stage stage=new Stage();
                    stage.setScene(scene);
                    Detalles controller = loader.getController();
                    controller.setController(HelloController.this);
                    controller.start(t1);
                    stage.setTitle("Detalles");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void instancias() {
        oTabla= FXCollections.observableArrayList();
        oTabla.add(new Persona("carlos","frances"));
        oTabla.add(new Persona("carla","carrasco"));
        oTabla.add(new Persona("juan","gomez"));
        oTabla.add(new Persona("clara","del olmo"));
        filtroTabla=new FilteredList(oTabla);
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        tabla.setItems(filtroTabla);
    }

    public void setController(Detalles controller){
        this.controller=controller;
    }

    public void recibirNombre(String nombre){
        labelRecepcion.setText(nombre);
    }
}