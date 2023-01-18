package com.example.t4_json;

import com.example.t4_json.model.Persona;
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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ImageView imageView;
    @FXML
    private ComboBox<String> comboGenero;
    private ObservableList<String> listaGenero;

    @FXML
    private Spinner<Integer> spinnerCantidad;
    private ObservableList<Integer> listaCantidad;

    @FXML
    private ListView<String> listViewResultados;
    private ObservableList<String> listaResultados;

    @FXML
    private Button botonBuscar;

    @FXML
    private Label labelNombre,labelMail,labelTelefono,labelPais;

    private String query=null;

    private String nombre=null;
    private String mail=null;
    private String telefono=null;
    private String pais=null;
    String imagen="";

    //Personass
    private ArrayList<Persona> personas = new ArrayList<Persona>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void asociarDatos() {
        comboGenero.setItems(listaGenero);
        listViewResultados.setItems(listaResultados);
        listViewResultados.getSelectionModel();
    }

    private void instancias() {
        listaGenero= FXCollections.observableArrayList();
        listaGenero.addAll("any","male","female");

        spinnerCantidad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100));

        listaResultados=FXCollections.observableArrayList();
    }

    private void resetLabels(){
        labelNombre.setText("");
        labelTelefono.setText("");
        labelPais.setText("");
        labelMail.setText("");
        imageView.setImage(null);
    }

    private void acciones() {
        botonBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(comboGenero.getSelectionModel().getSelectedIndex() <0) {System.out.println("Seleccione un genero");return;}
                resetLabels();
                String urlquery="https://randomuser.me/api/";
                listaResultados.clear();
                personas.clear();
                boolean sinGenero=false;
                switch (comboGenero.getSelectionModel().getSelectedIndex()){
                    case 0:sinGenero=true;break;
                    case 1:urlquery+="?gender=male";break;
                    case 2:urlquery+="?gender=female";break;
                }
                if(sinGenero) urlquery+="?results="+spinnerCantidad.getValueFactory().getValue().toString();
                else urlquery+="&results="+spinnerCantidad.getValueFactory().getValue().toString();

                try{
                    URL url = new URL(urlquery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
                    StringBuilder lectura = new StringBuilder();
                    String linea = null;

                    while((linea = bufferedReader.readLine())!= null){
                        lectura.append(linea);
                    }

                    JSONObject jsonGeneral = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = jsonGeneral.getJSONArray("results");
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        String nombre="";
                        String correo="";
                        String telefono="";
                        String pais="";
                        JSONObject resultado = arrayResultados.getJSONObject(i);
                        JSONObject nombreJson = resultado.getJSONObject("name");
                        nombre=nombreJson.getString("first");
                        listaResultados.add(i,nombre);
                        correo = resultado.getString("email");
                        telefono=resultado.getString("phone");
                        JSONObject paisJson = resultado.getJSONObject("location");
                        pais=paisJson.getString("country");
                        JSONObject imagenJson = resultado.getJSONObject("picture");
                        imagen = imagenJson.getString("large");
                        personas.add(i,new Persona(nombre,correo,telefono,pais,imagen));

                    }

                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //Seleccion del dato a mostrar


        listViewResultados.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (listViewResultados.getSelectionModel().getSelectedIndex() > -1) {
                    resetLabels();
                    labelNombre.setText(personas.get((int) t1).getNombre());
                    labelMail.setText(personas.get((int) t1).getCorreo());
                    labelPais.setText(personas.get((int) t1).getPais());
                    labelTelefono.setText(personas.get((int) t1).getTelefono());
                    imageView.setImage(new Image(personas.get((int) t1).getImagen()));
                }
            }
        });
        //todo preguntar como escuchar cambio de seleccion en la listview
        /*botonJson.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //peticion https
                //1-URL
                //2-Conexion por https
                //3-Evaluar la respuesta
                //4-pasar objeto String a Json
                String urlQuery = "https://randomuser.me/api/?results=5"; //1
                try {
                    URL url = new URL(urlQuery);//1

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //2

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
                    StringBuilder lectura = new StringBuilder();
                    String linea = null;
                    while((linea = bufferedReader.readLine())!= null){
                        lectura.append(linea);
                    }

                    JSONObject jsonGeneral = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = jsonGeneral.getJSONArray("results");
                    for (int q = 0; q < arrayResultados.length(); q++) {


                        JSONObject resultado1 = arrayResultados.getJSONObject(q);
                        JSONObject nombre = resultado1.getJSONObject("name");
                        String s = "";
                        s += "title: " + nombre.getString("title") + "\n";
                        s += "first: " + nombre.getString("first") + "\n";
                        s += "last : " + nombre.getString("last");

                        System.out.println(s);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/
    }
}