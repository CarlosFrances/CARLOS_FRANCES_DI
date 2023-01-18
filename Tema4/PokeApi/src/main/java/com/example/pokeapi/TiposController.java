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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TiposController implements Initializable {

    @FXML
    private Button botonEstadisticas;

    @FXML
    private Button botonMovimientos;

    @FXML
    private ImageView imagen;

    @FXML
    private ImageView imagenTipo1;

    @FXML
    private ImageView imagenTipo2;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelTipo1;

    @FXML
    private Label labelTipo2;

    @FXML
    private Label labelTipos;
    @FXML
    private BorderPane panelGeneral;


    MovimientosController controller;
    EstadisticasController controllerEstadisticas;
    private Pokemon pokemonActual;
    private String tipo1,tipo2;

    private Background background;

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
                        controller.setControladoraTipos(TiposController.this);
                        controller.start(pokemonActual,background);
                        stage.setTitle("Movimientos");
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
                    Scene scene = new Scene(root,botonMovimientos.getScene().getWidth(),botonMovimientos.getScene().getHeight());
                    Stage stage = (Stage) botonMovimientos.getScene().getWindow();
                    stage.setScene(scene);
                    EstadisticasController controller = loader.getController();
                    controller.setControladoraTipos(TiposController.this);
                    controller.start(pokemonActual,background);
                    stage.setTitle("Estadisticas");
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
    }

    private void instancias(Pokemon pokemon) {
        ArrayList<String> tipos = pokemon.getTipos();
        imagen.setImage(new Image(pokemon.getSprite()));
        labelNombre.setText(pokemon.getNombre());
        tipo1=tipos.get(0);
        if(tipos.size()>1) tipo2=tipos.get(1);
        setImagenesTipos(tipos);
        pokemonActual=pokemon;
    }

    private void setImagenesTipos(ArrayList<String> tipos) {
        String imagen1=null;
        String imagen2=null;
        if(tipos.get(0).equals("bug")){imagen1="bug.png";tipo1="bicho";}
        else if(tipos.get(0).equals("dark")){imagen1="dark.png";tipo1="siniestro";}
        else if(tipos.get(0).equals("dragon")){imagen1="dragon.png";tipo1="dragon";}
        else if(tipos.get(0).equals("electric")){imagen1="electric.png";tipo1="electrico";}
        else if(tipos.get(0).equals("fairy")){imagen1="fairy.png";tipo1="hada";}
        else if(tipos.get(0).equals("fighting")){imagen1="fighting.png";tipo1="lucha";}
        else if(tipos.get(0).equals("fire")){imagen1="fire.png";tipo1="fuego";}
        else if(tipos.get(0).equals("flying")){imagen1="flying.png";tipo1="volador";}
        else if(tipos.get(0).equals("ghost")){imagen1="ghost.png";tipo1="fantasma";}
        else if(tipos.get(0).equals("grass")){imagen1="grass.png";tipo1="planta";}
        else if(tipos.get(0).equals("ground")){imagen1="ground.png";tipo1="tierra";}
        else if(tipos.get(0).equals("ice")){imagen1="ice.png";tipo1="hielo";}
        else if(tipos.get(0).equals("normal")){imagen1="normal.png";tipo1="normal";}
        else if(tipos.get(0).equals("poison")){imagen1="poison.png";tipo1="veneno";}
        else if(tipos.get(0).equals("psychic")){imagen1="psychic.png";tipo1="psiquico";}
        else if(tipos.get(0).equals("rock")){imagen1="rock.png";tipo1="roca";}
        else if(tipos.get(0).equals("steel")){imagen1="steel.png";tipo1="acero";}
        else if(tipos.get(0).equals("water")){imagen1="water.png";tipo1="agua";}

        imagenTipo1.setImage(new Image(getClass().getResourceAsStream(imagen1)));
        labelTipo1.setText(tipo1);

        if(tipos.size() > 1){
            if(tipos.get(1).equals("bug")){imagen2="bug.png";tipo2="bicho";}
            else if(tipos.get(1).equals("dark")){imagen2="dark.png";tipo2="siniestro";}
            else if(tipos.get(1).equals("dragon")){imagen2="dragon.png";tipo2="dragon";}
            else if(tipos.get(1).equals("electric")){imagen2="electric.png";tipo2="electrico";}
            else if(tipos.get(1).equals("fairy")){imagen2="fairy.png";tipo2="hada";}
            else if(tipos.get(1).equals("fighting")){imagen2="fighting.png";tipo2="lucha";}
            else if(tipos.get(1).equals("fire")){imagen2="fire.png";tipo2="fuego";}
            else if(tipos.get(1).equals("flying")){imagen2="flying.png";tipo2="volador";}
            else if(tipos.get(1).equals("ghost")){imagen2="ghost.png";tipo2="fantasma";}
            else if(tipos.get(1).equals("grass")){imagen2="grass.png";tipo2="planta";}
            else if(tipos.get(1).equals("ground")){imagen2="ground.png";tipo2="tierra";}
            else if(tipos.get(1).equals("ice")){imagen2="ice.png";tipo2="hielo";}
            else if(tipos.get(1).equals("normal")){imagen2="normal.png";tipo2="normal";}
            else if(tipos.get(1).equals("poison")){imagen2="poison.png";tipo2="veneno";}
            else if(tipos.get(1).equals("psychic")){imagen2="psychic.png";tipo2="psiquico";}
            else if(tipos.get(1).equals("rock")){imagen2="rock.png";tipo2="roca";}
            else if(tipos.get(1).equals("steel")){imagen2="steel.png";tipo2="acero";}
            else if(tipos.get(1).equals("water")){imagen2="water.png";tipo2="agua";}
            imagenTipo2.setImage(new Image(getClass().getResourceAsStream(imagen2)));
            labelTipos.setText("Tipos");
            labelTipo2.setText(tipo2);
        }else labelTipos.setText("Tipo");


    }

    public void setControladora(MovimientosController controladora) {
        controller=controladora;
    }

    public void setControladoraEstadisticas(EstadisticasController controladora){
        controllerEstadisticas=controladora;
    }
}
