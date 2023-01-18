package com.example.examen_carlos_frances;

import com.example.examen_carlos_frances.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class Registro implements Initializable {

    @FXML
    private Button botonCerrar;

    @FXML
    private Button botonRegistrar;

    @FXML
    private ComboBox combo;

    @FXML
    private TextField textoCorreo;

    @FXML
    private TextField textoPassword;

    @FXML
    private TextField textoTelefono;

    @FXML
    private TextField textoUsuario;

    private HelloController controller;
    private ObservableList<String> listaCombo;
    private Usuario usuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        botonRegistrar.setOnAction(new Pulsaciones());
        botonCerrar.setOnAction(new Pulsaciones());
    }

    private void instancias() {
        listaCombo= FXCollections.observableArrayList();

        String urlQuery = "https://run.mocky.io/v3/48686b58-bd41-4f13-92c5-1fba0c56e74d";
        try {
            URL url = new URL(urlQuery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder lectura = new StringBuilder();
            String linea = null;
            while ((linea = bufferedInputStream.readLine())!=null){
                lectura.append(linea);
            }

            JSONArray jsonGeneral = new JSONArray(lectura.toString());
            for(int i = 0;i<jsonGeneral.length();i++){
                listaCombo.add(jsonGeneral.getString(i));
            }
            combo.setItems(listaCombo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setController(HelloController helloController) {
        this.controller=helloController;
    }

    private class Pulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent a) {
            if(a.getSource() == botonRegistrar){
                if(!textoUsuario.equals("") && !textoPassword.equals("") && !textoCorreo.equals("") && !textoTelefono.equals("") && combo.getSelectionModel().getSelectedIndex() > -1){
                    usuario=new Usuario(textoUsuario.getText(),textoPassword.getText(),textoCorreo.getText(),textoTelefono.getText(),combo.getSelectionModel().getSelectedItem().toString());
                    controller.registrarUsuario(usuario);
                    ((Stage)botonCerrar.getScene().getWindow()).close();
                }
            }else if(a.getSource() == botonCerrar){
                ((Stage)botonCerrar.getScene().getWindow()).close();
            }
        }
    }
}
