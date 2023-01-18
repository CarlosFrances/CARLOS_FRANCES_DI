package com.example.json_chuck_norris;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button botonAleatorio;

    @FXML
    private Button botonCAtegoria;

    @FXML
    private ComboBox<String> comboCategoria;
    private ObservableList<String> olcomboCategoria;

    @FXML
    private ImageView imagenCabecera;
    private String urlImagen="https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png";

    @FXML
    private ListView<String> listViewChistes;
    private ObservableList<String> olListViewChistes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        botonAleatorio.setOnAction(this);
        botonCAtegoria.setOnAction(this);
    }

    private void asociarDatos() {
        comboCategoria.setItems(olcomboCategoria);
        listViewChistes.setItems(olListViewChistes);
    }

    private void instancias() {
        imagenCabecera.setImage(new Image(urlImagen));
        olcomboCategoria = FXCollections.observableArrayList();
        addCategorias();
        olListViewChistes = FXCollections.observableArrayList();
    }

    private void addCategorias(){
        String urlquery="https://api.chucknorris.io/jokes/categories";

        try{
            URL url = new URL(urlquery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
            StringBuilder lectura = new StringBuilder();
            String linea = null;

            while((linea = bufferedReader.readLine())!=null){
                lectura.append(linea);
            }

            JSONArray arrayCategorias = new JSONArray(lectura.toString());
            for(int i = 0;i<arrayCategorias.length();i++){
                olcomboCategoria.add(arrayCategorias.get(i).toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == botonAleatorio){
            String urlquery ="https://api.chucknorris.io/jokes/random";

            try{
                URL url = new URL(urlquery);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
                StringBuilder lectura = new StringBuilder();
                String linea = null;

                linea = bufferedReader.readLine();
                JSONObject jsonGeneral = new JSONObject(linea);
                linea = jsonGeneral.getString("value");
                olListViewChistes.add(linea);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(actionEvent.getSource() == botonCAtegoria) {
            if (comboCategoria.getSelectionModel().getSelectedIndex() > -1) {
                try {
                    //https://api.chucknorris.io/jokes/random?category={category}
                    String urlquery = "https://api.chucknorris.io/jokes/random?category="+comboCategoria.getSelectionModel().getSelectedItem().toString();

                    URL url = new URL(urlquery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
                    StringBuilder lectura = new StringBuilder();
                    String linea = null;

                    linea = bufferedReader.readLine();
                    JSONObject jsonGeneral = new JSONObject(linea);
                    String resultadoFinal = jsonGeneral.getString("value");
                    olListViewChistes.add(resultadoFinal);



                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else System.out.println("Escoge una categoría");
        }
    }
}