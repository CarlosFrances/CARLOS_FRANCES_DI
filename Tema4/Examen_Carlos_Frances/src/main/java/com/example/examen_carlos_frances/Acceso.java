package com.example.examen_carlos_frances;

import com.example.examen_carlos_frances.model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Acceso implements Initializable {

    @FXML
    private TableColumn<?, ?> columnaCorreo;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaRol;

    @FXML
    private MenuItem itemAll;

    @FXML
    private MenuItem itemDeveloper;

    @FXML
    private MenuItem itemGuest;

    @FXML
    private MenuItem itemTest;

    @FXML
    private MenuItem itemUser;

    @FXML
    private TableView<Usuario> tabla;

    private HelloController controller;
    private ObservableList<Usuario> listaUsuarios;
    private FilteredList<Usuario> filtroUsuarios;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        itemUser.setOnAction(new Pulsaciones());
        itemDeveloper.setOnAction(new Pulsaciones());
        itemTest.setOnAction(new Pulsaciones());
        itemGuest.setOnAction(new Pulsaciones());
        itemAll.setOnAction(new Pulsaciones());
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario t1) {
                System.out.println(t1);
            }
        });
    }

    public void start(){
        filtroUsuarios=new FilteredList(listaUsuarios);
        tabla.setItems(filtroUsuarios);
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        columnaRol.setCellValueFactory(new PropertyValueFactory("perfil"));
    }

    public void setController(HelloController helloController) {
        this.controller=helloController;
    }

    public void recogerLista(ObservableList<Usuario> listaUsuarios) {
        this.listaUsuarios=listaUsuarios;
    }

    private class Pulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent a) {
            String pulsacion;
            if(a.getSource() == itemDeveloper){
                pulsacion="Developer";
            }else if(a.getSource() == itemUser){
                pulsacion="User";
            }else if(a.getSource() == itemGuest){
                pulsacion="Guest";
            }else if(a.getSource() == itemTest){
                pulsacion="Test";
            }
            else pulsacion="";
            filtroUsuarios.setPredicate(new Predicate<Usuario>() {
                @Override
                public boolean test(Usuario usuario) {
                    return usuario.getPerfil().contains(pulsacion);
                }
            });
        }
    }
}
