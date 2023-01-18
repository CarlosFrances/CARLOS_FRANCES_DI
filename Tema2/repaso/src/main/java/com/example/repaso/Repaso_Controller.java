package com.example.repaso;

import com.example.repaso.model.Equipo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Repaso_Controller implements Initializable {

    @FXML
    private Button botonInferior;

    @FXML
    private RadioButton radioRayo,radioMadrid,radioAtleti;
    private ToggleGroup grupoEquipos;

    @FXML
    private ImageView imagen;
    @FXML
    private Label textoEquipo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        grupoEquipos.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                Equipo seleccionado=(Equipo)((RadioButton)t1).getUserData();
                imagen.setImage(new Image(seleccionado.getImagen()));
                textoEquipo.setText(seleccionado.getNombre());
            }
        });
    }

    private void asociarDatos() {
        radioRayo.setUserData(new Equipo("Rayo Vallecano","https://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/2.png","Vallecas"));
        radioMadrid.setUserData(new Equipo("Real Madrid","https://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/1.png","Santiago Bernabeu"));
        radioAtleti.setUserData(new Equipo("Atletico de Madrid","https://play-lh.googleusercontent.com/IEJYbBqmahVEft_ZXZVqaR7OUf0wEJ9zHPGqG1_yi2Ff6Dtq9Ft0h5ZQcwSupJh5q5w5","Wanda Metropolitano"));
    }

    private void instancias() {
        grupoEquipos=new ToggleGroup();
        grupoEquipos.getToggles().addAll(radioMadrid,radioAtleti,radioRayo);
    }
}
