package com.example.repasoexamen;

import com.example.repasoexamen.model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class DNIBuscarController implements Initializable {

    @FXML
    private Button botonBuscar;

    @FXML
    private TextField textoDNI;
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
                controller.recepcionBuscarDNI(textoDNI.getText());
            }
        });
    }

    public void setControladora(MainController controladora){
        controller=controladora;
    }
}
