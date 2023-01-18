package com.example.examen_carlos_frances;

import com.example.examen_carlos_frances.model.Usuario;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button botonAcceder;

    @FXML
    private Button botonRegistrar;

    @FXML
    private TextField textoPassword;

    @FXML
    private TextField textoUsuario;

    private ObservableList<Usuario> listaUsuarios;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        insertarDatos();
        acciones();
    }

    private void insertarDatos() {
        listaUsuarios= FXCollections.observableArrayList();
        listaUsuarios.add(new Usuario("carlos","123","carlos@carlos","13467","Admin"));
        listaUsuarios.add(new Usuario("carla","1234","carla@carla","1346732","Test"));
        listaUsuarios.add(new Usuario("juan","12364","juan@juan","1344467","Admin"));
    }

    private void acciones() {
        botonAcceder.setOnAction(new Pulsaciones());
        botonRegistrar.setOnAction(new Pulsaciones());
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    private class Pulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent a) {
            if(a.getSource() == botonRegistrar){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("registro.fxml"));
                try {
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    Scene scene = new Scene(root,botonAcceder.getScene().getWidth(),botonAcceder.getScene().getHeight());
                    stage.setScene(scene);
                    Registro controller = loader.getController();
                    controller.setController(HelloController.this);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else if(a.getSource() == botonAcceder){
                String nombre = textoUsuario.getText();
                String password = textoPassword.getText();
                boolean priv = true;
                boolean exists= true;
                boolean access=false;
                for(int i=0;i<listaUsuarios.size();i++){
                    Usuario user=listaUsuarios.get(i);
                    if(user.getNombre().equals(nombre) && user.getPassword().equals(password)){
                        if(user.getPerfil().equals("Admin")){
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("acceso.fxml"));
                            try {
                                Parent root = loader.load();
                                Stage stage = new Stage();
                                Scene scene = new Scene(root,botonAcceder.getScene().getWidth(),botonAcceder.getScene().getHeight());
                                stage.setScene(scene);
                                Acceso controller = loader.getController();
                                controller.setController(HelloController.this);
                                controller.recogerLista(listaUsuarios);
                                controller.start();
                                stage.show();
                                access=true;
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }else priv=false;
                    }else exists=false;
                }
                if(access==false){
                    if(priv == false){System.out.println("No tienes suficientes privilegios");exists=true;}
                    if(exists == false)System.out.println("El usuario no existe");
                }
            }
        }
    }
}