package com.example.repasoexamen;

import com.example.repasoexamen.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class MainController implements Initializable {

    @FXML
    private Button botonCorreo;

    @FXML
    private Button botonDNI;

    @FXML
    private Button botonNombre;

    @FXML
    private Button botonTelefono;

    @FXML
    private TableColumn columnaCorreo;

    @FXML
    private TableColumn columnaDNI;

    @FXML
    private TableColumn columnaNombre;

    @FXML
    private TableColumn columnaTelefono;

    @FXML
    private MenuItem itemAgregar;

    @FXML
    private MenuItem itemAyuda;

    @FXML
    private MenuItem itemBorrar;

    @FXML
    private MenuItem itemBuscarDNI;

    @FXML
    private MenuItem itemReseteo;

    @FXML
    private MenuItem itemSalir;

    @FXML
    private Label labelCorreo;

    @FXML
    private Label labelDNI;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelTelefono;

    @FXML
    private TableView<Usuario> tablaUsuarios;
    private ObservableList<Usuario> otablaUsuario;
    private FilteredList<Usuario> filtroTablaUsuarios;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    public void recepcionNombre(String texto){labelNombre.setText(texto);}
    public void recepcionCorreo(String texto){labelCorreo.setText(texto);}
    public void recepcionDNI(String texto){labelDNI.setText(texto);}
    public void recepcionTelefono(String texto){labelTelefono.setText(texto);}
    public void recepcionBuscarDNI(String cadena){
        filtroTablaUsuarios.setPredicate(new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getDni().toLowerCase().contains(cadena.toLowerCase());
            }
        });
    }
    public void recepcionBorrar(String cadena){
        for(int i=0;i<otablaUsuario.size();i++){
            if(otablaUsuario.get(i).getDni().equals(cadena)){
                otablaUsuario.remove(i);
            }
        }
    }

    private void acciones() {
        itemAyuda.setOnAction(new ManejoPulsaciones());
        itemBorrar.setOnAction(new ManejoPulsaciones());
        itemSalir.setOnAction(new ManejoPulsaciones());
        botonNombre.setOnAction(new ManejoPulsaciones());
        botonCorreo.setOnAction(new ManejoPulsaciones());
        botonDNI.setOnAction(new ManejoPulsaciones());
        botonTelefono.setOnAction(new ManejoPulsaciones());
        botonDNI.setOnAction(new ManejoPulsaciones());
        itemAgregar.setOnAction(new ManejoPulsaciones());
        itemBuscarDNI.setOnAction(new ManejoPulsaciones());
        itemReseteo.setOnAction(new ManejoPulsaciones());
    }

    private void asociarDatos() {
        filtroTablaUsuarios=new FilteredList(otablaUsuario);
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        columnaDNI.setCellValueFactory(new PropertyValueFactory("dni"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        tablaUsuarios.setItems(filtroTablaUsuarios);
    }

    private void instancias() {
        otablaUsuario = FXCollections.observableArrayList();
        otablaUsuario.add(new Usuario("a","b","antonio","1"));
        otablaUsuario.add(new Usuario("a","b","carlos","1"));
        otablaUsuario.add(new Usuario("a","b","mauricio","1"));
        otablaUsuario.add(new Usuario("a","b","carla","1"));
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent a) {
            if(a.getSource() == itemAyuda){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ayuda-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Ayuda");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(a.getSource() == itemBorrar){
                if(otablaUsuario.isEmpty()){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("error-view.fxml"));
                    try {
                        Parent root = loader.load();
                        Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Error");
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("borrar-view.fxml"));
                    try {
                        Parent root = loader.load();
                        Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        BorrarController controller = loader.getController();
                        controller.setControladora(MainController.this);
                        stage.setTitle("Inserte DNI a borrar");
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if(a.getSource() == itemSalir){System.exit(0);}
            if(a.getSource() == botonNombre){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("nombre-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    NombreController controller = loader.getController();
                    controller.setControladora(MainController.this);
                    stage.setTitle("Inserte Nombre");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(a.getSource() == botonCorreo){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("correo-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    CorreoController controller = loader.getController();
                    controller.setControladora(MainController.this);
                    stage.setTitle("Inserte Correo");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(a.getSource() == botonDNI){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dni-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    DNIController controller = loader.getController();
                    controller.setControladora(MainController.this);
                    stage.setTitle("Inserte DNI");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(a.getSource() == botonTelefono){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("telefono-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    TelefonoController controller = loader.getController();
                    controller.setControladora(MainController.this);
                    stage.setTitle("Inserte Telefono");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(a.getSource() == itemAgregar){
                if(labelNombre.getText().equals("Sin datos") || labelCorreo.getText().equals("Sin datos") || labelDNI.getText().equals("Sin datos") || labelTelefono.getText().equals("Sin datos")){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("error-view.fxml"));
                    try {
                        Parent root = loader.load();
                        Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Error");
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    otablaUsuario.add(new Usuario(labelNombre.getText(),labelCorreo.getText(),labelDNI.getText(),labelTelefono.getText()));
                }
            }
            if(a.getSource() == itemBuscarDNI){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dnibuscar-view.fxml"));
                try{
                    Parent root = loader.load();
                    Scene scene = new Scene(root,botonCorreo.getScene().getWidth(),botonCorreo.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    DNIBuscarController controller = loader.getController();
                    controller.setControladora(MainController.this);
                    stage.setTitle("Buscar por DNI");
                    stage.show();
                }catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
            if(a.getSource() == itemReseteo){
                filtroTablaUsuarios.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return true;
                    }
                });
            }
        }
    }
}
