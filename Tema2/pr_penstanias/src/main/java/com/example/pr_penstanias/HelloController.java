package com.example.pr_penstanias;

import com.example.pr_penstanias.model.CambioBase;
import com.example.pr_penstanias.model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    //Paneles
    @FXML
    BorderPane panelGeneral;
    @FXML
    GridPane panelVisible;

    //Botones, toggles y radios
    @FXML
    Button botonNormal1,botonNormal2,botonMostrar,botonCalcular,botonOcultar,botonListas;
    @FXML
    ToggleButton toggle;
    @FXML
    RadioButton radioDos,radioOcho,radioDieciseis;
    ToggleGroup grupoRadios;

    //Textos
    @FXML
    TextField textoOperar;

    //Efectos
    private DropShadow sombra;

    //Listas. Hay que inicializarlas en instancias()
    @FXML
    ChoiceBox<String> choice;
    private ObservableList<String> listaChoice;
    @FXML
    ComboBox<String> combo;
    private ObservableList<String> listaCombo;
    @FXML
    Spinner<Integer> spinner;
    private ObservableList<Integer> listaSpinner;
    @FXML
    ListView<Usuario> lista;
    private ObservableList<Usuario> listaListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGui();
        personalizar();
        asociarDatos();
        acciones();
    }

    private void asociarDatos() {
        radioDos.setUserData(new CambioBase(0,2));
        radioOcho.setUserData(new CambioBase(0,8));
        radioDieciseis.setUserData(new CambioBase(0,16));

        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
        lista.setItems(listaListView);
        spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(listaSpinner));
    }

    private void acciones() {
        //EventHandler para eventos de raton
        botonNormal1.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal1.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        botonNormal2.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal2.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        //SetonAction para las pulsaciones
        botonMostrar.setOnAction(new ManejoPulsaciones());
        botonOcultar.setOnAction(new ManejoPulsaciones());
        botonNormal1.setOnAction(new ManejoPulsaciones());
        botonNormal2.setOnAction(new ManejoPulsaciones());
        botonCalcular.setOnAction(new ManejoPulsaciones());

        //selectedToggleProperty para los toggleGroup
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println(((RadioButton)t1).getText());
            }
        });

        //selectedProperty para toggle
        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(t1){
                    toggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                }else{
                    toggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                }
                botonNormal1.setDisable(t1);
                botonNormal2.setDisable(t1);
            }
        });

        botonListas.setOnAction(new ManejoPulsaciones());

    }

    private void personalizar() {
        //botones
        botonNormal1.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal1.setBackground(null);
        botonNormal2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormal2.setBackground(null);
        toggle.setBackground(null);
        toggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
    }

    private void initGui() {
        panelGeneral.getChildren().remove(panelVisible);
    }

    private void instancias() {
        //Inicializar el grupo de radios
        grupoRadios=new ToggleGroup();
        grupoRadios.getToggles().addAll(radioDos,radioOcho,radioDieciseis);

        //Efectos
        sombra= new DropShadow();

        //Inicializar listas
        listaCombo= FXCollections.observableArrayList();
        listaCombo.addAll("OpcionCB1","OpcionCB2","OpcionCB3","OpcionCB4");

        listaChoice=FXCollections.observableArrayList();
        listaChoice.addAll("OpcionCH1","OpcionCH2","OpcionCH3","OpcionCH4");

        listaSpinner=FXCollections.observableArrayList();
        listaSpinner.addAll(1,2,3,4,5,6,7,8,9,10);

        listaListView=FXCollections.observableArrayList();
        listaListView.addAll(
                new Usuario("carlos","Frances","carlos@gmail.com",1),
                new Usuario("Alejandro","Berro","aberro@gmail.com",2),
                new Usuario("Diego","Salinas","diego@gmail.com",3),
                new Usuario("David","Vinagrero","david@gmail.com",4),
                new Usuario("Juan","Gomez","juan@gmail.com",5)
        );

    }

    private class ManejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                ((Button) mouseEvent.getSource()).setEffect(sombra);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) mouseEvent.getSource()).setEffect(null);
            }
        }
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == botonMostrar) panelGeneral.setLeft(panelVisible);
            else if(actionEvent.getSource() == botonOcultar) panelGeneral.getChildren().remove(panelVisible);
            else if(actionEvent.getSource() == botonNormal1) toggle.setSelected(true);
            else if(actionEvent.getSource() == botonNormal2) toggle.setSelected(false);
            else if(actionEvent.getSource() == botonCalcular){
                if(grupoRadios.getSelectedToggle() != null && !textoOperar.getText().isEmpty()){
                    RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                    //Creamos un objeto de tipo CambioBase y le asociamos los datos del CambioBase del toggle seleccionado
                    CambioBase cambioBase = (CambioBase) radioSeleccionado.getUserData();
                    cambioBase.setNumeroDecimal(Integer.valueOf(textoOperar.getText()));
                    cambioBase.cambioBase();
                    System.out.println(cambioBase.getNumeroConv());
                }
            }
            else if(actionEvent.getSource() == botonListas){
                if(combo.getSelectionModel().getSelectedIndex() > -1 &&
                    choice.getSelectionModel().getSelectedIndex() > -1 &&
                    lista.getSelectionModel().getSelectedIndex() > -1){
                    System.out.println("combo: "+combo.getSelectionModel().getSelectedItem().toString());
                    System.out.println("choice: "+choice.getSelectionModel().getSelectedItem().toString());
                    System.out.println("lista: "+lista.getSelectionModel().getSelectedItem().toString());
                    System.out.println("spinner: "+spinner.getValueFactory().getValue().toString());
                    listaListView.add(new Usuario("jose","garcia","jose@gmail.com",23));
                }
            }
        }
    }
}