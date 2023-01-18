package com.example.pr_pestanias_2;

import com.example.pr_pestanias_2.model.Abonado;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button botonAgregar,botonEliminar;
    @FXML
    private RadioButton radioMadrid,radioAtleti,radioBarsa,radioHombre,radioMujer;
    private ToggleGroup grupoRadiosEquipos;
    private ToggleGroup grupoRadiosSexos;

    @FXML
    private ToggleButton toggle,toggleMostrarOcultar;

    @FXML
    private Spinner<Integer> spinnerEdad;
    private ObservableList<Integer> listaSpinnerEdad;
    @FXML
    private ChoiceBox<String> choiceLocalidad;
    private ObservableList<String> listaChoiceLocalidad;

    @FXML
    private ListView listViewAbonados;
    private ObservableList listaListviewAbonados;

    @FXML
    private ImageView imagen;

    @FXML
    private BorderPane panelGeneral;
    @FXML
    private GridPane panelVisible;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        initGUI();
        acciones();
    }

    private void initGUI() {
        panelGeneral.getChildren().remove(panelVisible);
    }

    private void acciones() {
        botonAgregar.setOnAction(new ManejoPulsaciones());
        botonEliminar.setOnAction(new ManejoPulsaciones());
        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                toggleMostrarOcultar.setDisable(!t1);
                if(t1){
                    toggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                }
                else{
                    toggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                }
            }
        });
        toggleMostrarOcultar.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(t1) panelGeneral.setLeft(panelVisible);
                else panelGeneral.getChildren().remove(panelVisible);
            }
        });
        grupoRadiosEquipos.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if(t1 == radioAtleti){
                    imagen.setImage(new Image(getClass().getResourceAsStream("atleti.jpg")));
                }
                else if(t1 == radioMadrid){
                    imagen.setImage(new Image(getClass().getResourceAsStream("madrid.jpg")));
                }
                else if(t1 == radioBarsa){
                    imagen.setImage(new Image(getClass().getResourceAsStream("barsa.jpg")));
                }
            }
        });
    }

    private void asociarDatos() {
        spinnerEdad.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(listaSpinnerEdad));
        choiceLocalidad.setItems(listaChoiceLocalidad);
        listViewAbonados.setItems(listaListviewAbonados);


    }

    private void instancias() {
        listaSpinnerEdad= FXCollections.observableArrayList();
        listaSpinnerEdad.addAll(15,16,17,18,19,20);

        listaChoiceLocalidad=FXCollections.observableArrayList();
        listaChoiceLocalidad.addAll("majada","Las Ramblas","Getafe");

        listaListviewAbonados=FXCollections.observableArrayList();

        grupoRadiosEquipos=new ToggleGroup();
        grupoRadiosEquipos.getToggles().addAll(radioAtleti,radioBarsa,radioMadrid);

        grupoRadiosSexos=new ToggleGroup();
        grupoRadiosSexos.getToggles().addAll(radioHombre,radioMujer);

        toggleMostrarOcultar.setDisable(true);
        toggle.setBackground(null);
        toggle.setText("");
        toggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource()==botonAgregar){
                if(choiceLocalidad.getSelectionModel().getSelectedIndex()>-1 &&
                    grupoRadiosEquipos.getSelectedToggle() != null &&
                    grupoRadiosSexos.getSelectedToggle() != null){
                    int edad= spinnerEdad.getValueFactory().getValue();
                    RadioButton radioSeleccionado = (RadioButton) grupoRadiosEquipos.getSelectedToggle();
                    String localidad= choiceLocalidad.getValue();
                    String equipo=radioSeleccionado.getText();
                    radioSeleccionado = (RadioButton) grupoRadiosSexos.getSelectedToggle();
                    String sexo=radioSeleccionado.getText();
                    listaListviewAbonados.add(new Abonado(edad,localidad,equipo,sexo));
                }
            }
            else if(actionEvent.getSource() == botonEliminar){
                if(listViewAbonados.getSelectionModel().getSelectedIndex() > -1){
                    listViewAbonados.getItems().remove(listViewAbonados.getSelectionModel().getSelectedIndex());
                }
            }
        }
    }
}