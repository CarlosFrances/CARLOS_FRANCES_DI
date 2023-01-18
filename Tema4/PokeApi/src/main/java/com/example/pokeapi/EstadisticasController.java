package com.example.pokeapi;

import com.example.pokeapi.model.Pokemon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
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

public class EstadisticasController implements Initializable {

    @FXML
    private Rectangle barraAtaque;

    @FXML
    private Rectangle barraAtaqueEspecial;

    @FXML
    private Rectangle barraDefensa;

    @FXML
    private Rectangle barraDefensaEspecial;

    @FXML
    private Rectangle barraHp;

    @FXML
    private Rectangle barraVelocidad;

    @FXML
    private Button botonMovimientos;

    @FXML
    private Button botonTipos;

    @FXML
    private ImageView imagen;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelAtaque;

    @FXML
    private Label labelAtaqueEspecial;

    @FXML
    private Label labelDefensa;

    @FXML
    private Label labelDefensaEspecial;

    @FXML
    private Label labelHp;

    @FXML
    private Label labelVelocidad;

    @FXML
    private Label labelTotal;

    @FXML
    private BorderPane panelGeneral;
    private Background background;

    private Pokemon pokemonActual;

    MovimientosController controller;
    TiposController controllerTipos;
    private ArrayList<Integer> estadisticas=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonMovimientos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("movimientos-view.fxml"));
                try {
                    Parent root=loader.load();
                    Scene scene = new Scene(root,botonMovimientos.getScene().getWidth(),botonMovimientos.getScene().getHeight());
                    Stage stage = (Stage) botonMovimientos.getScene().getWindow();
                    stage.setScene(scene);
                    MovimientosController controller = loader.getController();
                    controller.setControladoraEstadisticas(EstadisticasController.this);
                    controller.start(pokemonActual,background);
                    stage.setTitle("Movimientos");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        botonTipos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tipos-view.fxml"));
                try {
                    Parent root=loader.load();
                    Scene scene = new Scene(root,botonMovimientos.getScene().getWidth(),botonMovimientos.getScene().getHeight());
                    Stage stage = (Stage) botonMovimientos.getScene().getWindow();
                    stage.setScene(scene);
                    TiposController controller = loader.getController();
                    controller.setControladoraEstadisticas(EstadisticasController.this);
                    controller.start(pokemonActual,background);
                    stage.setTitle("Tipos");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void start(Pokemon pokemon,Background background){
        instancias(pokemon);
        this.background=background;
        panelGeneral.setBackground(background);
        estadisticas=obtenerEstadisticas(pokemon.getNumero());
        setEstadisticas(estadisticas);
    }

    private void setEstadisticas(ArrayList<Integer> estadisticas) {
        Integer total=0;
        barraHp.setWidth(estadisticas.get(0)*2.5);
        total+=estadisticas.get(0);
        labelHp.setText(estadisticas.get(0).toString());
        barraAtaque.setWidth(estadisticas.get(1)*2.5);
        total+=estadisticas.get(1);
        labelAtaque.setText(estadisticas.get(1).toString());
        barraAtaqueEspecial.setWidth(estadisticas.get(3)*2.5);
        total+=estadisticas.get(3);
        labelAtaqueEspecial.setText(estadisticas.get(3).toString());
        barraDefensa.setWidth(estadisticas.get(2)*2.5);
        total+=estadisticas.get(2);
        labelDefensa.setText(estadisticas.get(2).toString());
        barraDefensaEspecial.setWidth(estadisticas.get(4)*2.5);
        total+=estadisticas.get(4);
        labelDefensaEspecial.setText(estadisticas.get(4).toString());
        barraVelocidad.setWidth(estadisticas.get(5)*2.5);
        total+=estadisticas.get(5);
        labelVelocidad.setText(estadisticas.get(5).toString());

        labelTotal.setText(total.toString());
    }

    private ArrayList<Integer> obtenerEstadisticas(int n) {
        String urlquery="https://pokeapi.co/api/v2/pokemon/"+n;
        ArrayList<Integer> listaDeEstadisticas = new ArrayList<>();
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
            JSONArray listaMovimientos = jsonGeneral.getJSONArray("stats");
            for (int i = 0; i < listaMovimientos.length(); i++) {
                JSONObject stats=listaMovimientos.getJSONObject(i);
                int nombre = stats.getInt("base_stat");

                listaDeEstadisticas.add(nombre);
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        return listaDeEstadisticas;
    }

    private void instancias(Pokemon pokemon) {
        pokemonActual=pokemon;
        imagen.setImage(new Image(pokemon.getSprite()));
        labelNombre.setText(pokemon.getNombre());
    }

    public void setControladora(MovimientosController controladora){
        controller=controladora;
    }

    public void setControladoraTipos(TiposController controladora){controllerTipos=controladora;}
}
