package com.example.pokeapi;

import com.example.pokeapi.model.Pokemon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class PokeController implements Initializable {
    @FXML
    private ImageView imagen;

    @FXML
    private Spinner<Integer> spinnerNumero;

    @FXML
    private TextField textoNombre;


    @FXML
    private TableView<Pokemon> tablaPokemon;
    private ObservableList<Pokemon> oTablaPokemon;
    private FilteredList<Pokemon> filtroTablaPokemon;

    @FXML
    private TableColumn columnaNumero,columnaPokemon;

    @FXML
    private ToggleButton toggleSpinner;

    @FXML
    private MenuItem menuItemMenuUtilesSalir;
    @FXML
    private RadioMenuItem menuItemSpriteFrontNormal,menuItemSpriteFrontShiny,menuItemSpriteBackNormal,menuItemSpriteBackShiny,
            radioPokeball,radioMasterball,radioTentacool,radioPikachu,radioGreninja,radioQuitarFondo;
    private ToggleGroup grupoMenu;
    private ToggleGroup grupoFondos;
    @FXML
    private BorderPane panelGeneral;
    @FXML
    private Button botonDetalles;

    private Pokemon pokemonActual;
    private String imagenActual;

    private Background backgroundEleccion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        // Sacar los movimientos de cada pokemon a la listview al clickar
        tablaPokemon.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pokemon>() {
            @Override
            public void changed(ObservableValue<? extends Pokemon> observableValue, Pokemon pokemon, Pokemon t1) {
                String sprite = obtenerSprite(t1.getNumero());
                imagen.setImage(new Image(obtenerSprite(t1.getNumero())));
                pokemonActual = new Pokemon(t1.getNombre(),t1.getNumero(),imagenActual);
                botonDetalles.setDisable(false);
            }
        });

        botonDetalles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pokemonActual.setSprite(imagenActual);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("movimientos-view.fxml"));
                try {
                    Parent root=loader.load();
                    Scene scene = new Scene(root,botonDetalles.getScene().getWidth(),botonDetalles.getScene().getHeight());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    MovimientosController controller = loader.getController();
                    controller.setControladora(PokeController.this);
                    controller.start(pokemonActual,backgroundEleccion);
                    stage.setTitle("Movimientos");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Filtrar los pokemon por nombre al cambiar el textoNombre
        textoNombre.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(!textoNombre.getText().equals("")){
                    filtroTablaPokemon.setPredicate(new Predicate<Pokemon>() {
                        @Override
                        public boolean test(Pokemon pokemon) {
                            return pokemon.getNombre().toUpperCase().contains(t1.toUpperCase());
                        }
                    });
                }
            }
        });

        // Filtrar por el número al cambiar el spinner
        spinnerNumero.getValueFactory().valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                filtroTablaPokemon.setPredicate(new Predicate<Pokemon>() {
                    @Override
                    public boolean test(Pokemon pokemon) {
                        textoNombre.setText("");
                        return pokemon.getNumero() == t1;
                    }
                });
            }
        });

        // activar / desactivar spinner  con el toggle
        toggleSpinner.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                setGUI(!t1);
                if(t1){
                    oTablaPokemon.clear();
                    spinnerNumero.setDisable(true);
                    asociarDatos();
                }else{
                    spinnerNumero.setDisable(false);
                }
            }
        });

        // Cambiar la imagen cuando se clicke en el menuItem corresponidente
        grupoMenu.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                imagen.setImage(new Image(obtenerSprite(pokemonActual.getNumero())));
            }
        });

        // Cambiar fondo segun eleccion del grupoFondo
        grupoFondos.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                String eleccion=null;
                RadioMenuItem radioSeleccionado = (RadioMenuItem) grupoFondos.getSelectedToggle();
                if(radioSeleccionado == radioMasterball){eleccion = "bg_masterball.png";}
                else if(radioSeleccionado == radioGreninja){eleccion = "bg_greninja.png";}
                else if(radioSeleccionado == radioPikachu){eleccion = "bg_pikachu.png";}
                else if(radioSeleccionado == radioTentacool){eleccion = "bg_tentacool.png";}
                else if(radioSeleccionado == radioPokeball){eleccion = "bg_pokeball.png";}
                else if(radioSeleccionado == radioQuitarFondo){eleccion = "bg_white.png";}
                BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);

                Background background = new Background(new BackgroundImage(new Image(getClass().getResourceAsStream(eleccion)),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        bSize));
                panelGeneral.setBackground(background);
                backgroundEleccion=background;
            }
        });
        menuItemMenuUtilesSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    private void asociarDatos() {
        String urlquery="https://pokeapi.co/api/v2/pokemon?limit=898/";
        try{
            URL url = new URL(urlquery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));//3
            StringBuilder lectura = new StringBuilder();
            String linea = null;

            while((linea = bufferedReader.readLine())!=null){
                lectura.append(linea);
            }

            JSONObject jsonGeneral = new JSONObject(lectura.toString());
            JSONArray arrayResultados = jsonGeneral.getJSONArray("results");
            for (int i = 0; i < arrayResultados.length(); i++) {
                JSONObject resultado=arrayResultados.getJSONObject(i);
                String nombre = resultado.getString("name");
                String a = String.valueOf(nombre.charAt(0));
                a = a.toUpperCase();
                nombre = nombre.substring(1);
                a+=nombre;

                oTablaPokemon.add(new Pokemon(a,i+1));
            }
            filtroTablaPokemon=new FilteredList(oTablaPokemon);
            columnaNumero.setCellValueFactory(new PropertyValueFactory("numero"));
            columnaPokemon.setCellValueFactory(new PropertyValueFactory("nombre"));
            tablaPokemon.setItems(filtroTablaPokemon);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String obtenerSprite(int n){
        RadioMenuItem seleccion = (RadioMenuItem) grupoMenu.getSelectedToggle();
        if(seleccion == menuItemSpriteFrontShiny){
            imagenActual="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+n+".png";
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+n+".png";
        }else if(seleccion == menuItemSpriteBackNormal){
            imagenActual="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/"+n+".png";
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/"+n+".png";
        }else if(seleccion == menuItemSpriteBackShiny){
            imagenActual="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/"+n+".png";
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/"+n+".png";
        }else {
            imagenActual="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+n+".png";
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+n+".png";
        }
    }


    private void instancias() {
        grupoMenu = new ToggleGroup();
        grupoMenu.getToggles().addAll(menuItemSpriteFrontNormal,menuItemSpriteFrontShiny,menuItemSpriteBackNormal,menuItemSpriteBackShiny);
        grupoFondos = new ToggleGroup();
        grupoFondos.getToggles().addAll(radioPokeball,radioMasterball,radioGreninja,
                radioTentacool,radioPikachu,radioQuitarFondo);

        spinnerNumero.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,898));

        oTablaPokemon = FXCollections.observableArrayList();

        //todo
        /*olistaMovimientos = FXCollections.observableArrayList();
        listaMovimientos.setItems(olistaMovimientos);*/

        botonDetalles.setDisable(true);
        setGUI(true);
    }

    private void setGUI(boolean b) {
        if(!b){
            toggleSpinner.setBackground(null);
            Image imageOk = new Image(getClass().getResourceAsStream("power_on.png"));
            ImageView img = new ImageView(imageOk);
            img.setFitWidth(30);
            img.setFitHeight(30);
            toggleSpinner.setGraphic(img);
        }else{
            toggleSpinner.setBackground(null);
            Image imageOk = new Image(getClass().getResourceAsStream("power_off.png"));
            ImageView img = new ImageView(imageOk);
            img.setFitWidth(30);
            img.setFitHeight(30);
            toggleSpinner.setGraphic(img);
        }
    }
}