package com.example.pokeapi;

import com.example.pokeapi.model.Pokemon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MovimientosController implements Initializable {

    @FXML
    private Label labelNombre;
    @FXML
    private ImageView imagen;
    @FXML
    private Label labelMovimientos,labelTipos;

    @FXML
    private Button botonEstadisticas,botonTipos;

    @FXML
    private ListView <String>listaMovimientos;

    @FXML
    private BorderPane panelGeneral;
    private ObservableList<String> olistaMovimientos;

    PokeController controller;
    TiposController controllerTipos;
    EstadisticasController controllerEstadisticas;
    private ArrayList<String> listaTipos=new ArrayList<>();
    private Pokemon pokemonActual;
    private Background background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonTipos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tipos-view.fxml"));
                try {
                    Parent root=loader.load();
                    Scene scene = new Scene(root,botonTipos.getScene().getWidth(),botonTipos.getScene().getHeight());
                    Stage stage = (Stage) botonTipos.getScene().getWindow();
                    stage.setScene(scene);
                    TiposController controller = loader.getController();
                    controller.setControladora(MovimientosController.this);
                    controller.start(pokemonActual,background);
                    stage.setTitle("Tipos");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        botonEstadisticas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("estadisticas-view.fxml"));
                try {
                    Parent root=loader.load();
                    Scene scene = new Scene(root,botonTipos.getScene().getWidth(),botonTipos.getScene().getHeight());
                    Stage stage = (Stage) botonTipos.getScene().getWindow();
                    stage.setScene(scene);
                    EstadisticasController controller = loader.getController();
                    controller.setControladora(MovimientosController.this);
                    controller.start(pokemonActual,background);
                    stage.setTitle("Estadisticas");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    public void start(Pokemon pokemon, Background background){
        instancias(pokemon);
        this.background=background;
        panelGeneral.setBackground(background);
        olistaMovimientos.addAll(obtenerMovimientos(pokemon.getNumero()));
    }

    private void instancias(Pokemon pokemon){
        labelNombre.setText(pokemon.getNombre());
        labelMovimientos.setText("Movimientos que "+pokemon.getNombre()+" puede aprender");
        imagen.setImage(new Image(pokemon.getSprite()));
        olistaMovimientos= FXCollections.observableArrayList();
        listaMovimientos.setItems(olistaMovimientos);
        listaTipos=obtenerTipos(pokemon.getNumero());
        pokemonActual=new Pokemon(pokemon.getNombre(),pokemon.getNumero(),pokemon.getSprite(),listaTipos);
    }

    private ArrayList<String> obtenerTipos(int n) {
        String urlquery="https://pokeapi.co/api/v2/pokemon/"+n;
        ArrayList<String> listaDeTipos = new ArrayList<>();
        try {
            URL url = new URL(urlquery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
            StringBuilder lectura = new StringBuilder();
            String linea = null;

            while((linea = bufferedReader.readLine())!=null){
                lectura.append(linea);
            }

            JSONObject jsonGeneral = new JSONObject(lectura.toString());
            JSONArray listaTipos = jsonGeneral.getJSONArray("types");
            for (int i = 0; i < listaTipos.length(); i++) {
                JSONObject tipos= listaTipos.getJSONObject(i);
                JSONObject tipo = tipos.getJSONObject("type");
                String nombre = tipo.getString("name");

                listaDeTipos.add(nombre);
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        return listaDeTipos;
    }

    private ArrayList<String> obtenerMovimientos(int n) {
        String urlquery="https://pokeapi.co/api/v2/pokemon/"+n;
        ArrayList<String> listaDeMovimientos = new ArrayList<>();
        try {
            URL url = new URL(urlquery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
            StringBuilder lectura = new StringBuilder();
            String linea = null;

            while((linea = bufferedReader.readLine())!=null){
                lectura.append(linea);
            }

            JSONObject jsonGeneral = new JSONObject(lectura.toString());
            JSONArray listaMovimientos = jsonGeneral.getJSONArray("moves");
            for (int i = 0; i < listaMovimientos.length(); i++) {
                JSONObject movimientos= listaMovimientos.getJSONObject(i);
                JSONObject movimiento = movimientos.getJSONObject("move");
                String nombre = movimiento.getString("name");

                listaDeMovimientos.add(nombre);
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        return listaDeMovimientos;
    }


    public void setControladora(PokeController controladora) {
        controller=controladora;
    }
    public void setControladoraTipos(TiposController controladora){
        controllerTipos=controladora;
    }

    public void setControladoraEstadisticas(EstadisticasController controladora){
        controllerEstadisticas=controladora;
    }
}
