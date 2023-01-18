package com.example.t4_tablas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TableController implements Initializable {

    @FXML
    private TextField textoFiltrar;

    @FXML
    private TableColumn columnaApellido;

    @FXML
    private TableColumn columnaCorreo;

    @FXML
    private TableColumn columnaNombre;

    @FXML
    private TableColumn columnaTelefono;

    @FXML
    private TableView<Usuario> tabla;
    private ObservableList<Usuario> listaUsuarios;
    private FilteredList<Usuario> listaFiltrada;

    @FXML
    Button botonAnadir,botonEliminar,botonDetalles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        botonDetalles.setOnAction(new ManejoPulsaciones());
        botonEliminar.setOnAction(new ManejoPulsaciones());
        botonAnadir.setOnAction(new ManejoPulsaciones());

        textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getNombre().contains(t1);
                    }
                });
            }
        });
    }

    private void asociarDatos() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        tabla.setItems(listaFiltrada);
    }

    private void instancias() {
        listaUsuarios= FXCollections.observableArrayList();
        listaUsuarios.addAll(new Usuario("Borja","Martin","correo@correo.com","1234A",12345,30));
        listaUsuarios.addAll(new Usuario("Carlos","Frances","correo@correo.com","1234B",12346,20));
        listaUsuarios.addAll(new Usuario("Alejandro","Berro","correo@correo.com","1234C",12347,40));
        listaUsuarios.addAll(new Usuario("Fran","Rivera","correo@correo.com","1234D",12384,33));

        listaFiltrada=new FilteredList(listaUsuarios);
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == botonDetalles){
                if(tabla.getSelectionModel().getSelectedIndex() >-1){
                    System.out.println(tabla.getSelectionModel().getSelectedItem().toString());
                    tabla.getSelectionModel().clearSelection();
                }else System.out.println("Elige una fila");
            }else if (actionEvent.getSource() == botonAnadir){
                listaUsuarios.add(new Usuario("nuevo","usuario","correo@correo.com","1234T",354642,55));
            }else if(actionEvent.getSource() == botonEliminar){
                if(tabla.getSelectionModel().getSelectedIndex() >-1){
                    listaUsuarios.remove(tabla.getSelectionModel().getSelectedIndex());
                    tabla.getSelectionModel().clearSelection();
                }else System.out.println("Elige una fila");
            }
        }
    }
}
