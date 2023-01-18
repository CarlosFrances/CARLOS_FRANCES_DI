package com.example.penstanias;

import com.example.penstanias.model.CambioBase;
import com.example.penstanias.model.Usuario;
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

public class MainController implements Initializable {

    @FXML
    private Button botonNormal,botonNormal2,botonCalcular,botonMostrar,botonOcultar,botonListas;

    @FXML
    private ToggleButton toggle;

    @FXML
    private RadioButton radioUno,radioDos,radioTres;

    @FXML
    private TextField textoOperar;

    @FXML
    private GridPane panelVisible;

    @FXML
    private ChoiceBox<Usuario> choice;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private ListView<Usuario> lista;
    private ObservableList<Usuario> listaListView;

    private ObservableList<Integer> listaSpinner;

    private ObservableList<String> listaCombo,listaChoice;

    private ObservableList<Usuario> listaUsuarios;

    @FXML
    private BorderPane panelGeneral;

    private ToggleGroup grupoRadios;

    private DropShadow sombraExterior;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        personalizarBotones();
        asociarDatos();
        acciones();

    }

    private void initGUI() {
        panelGeneral.getChildren().remove(panelVisible);
    }

    private void asociarDatos(){
        //Asociar datos al ListView
        lista.setItems(listaListView);
        //Asociar items al spinner
        //spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,50));
        spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(listaSpinner));
        //Asociar los items a las listas
        combo.setItems(listaCombo);
        //choice.setItems(listaU);
        choice.setItems(listaUsuarios);
        //Asociar radios a objetos
        radioUno.setUserData(new CambioBase(0,2));
        radioDos.setUserData(new CambioBase(0,8));
        radioTres.setUserData(new CambioBase(0,16));
    }

    private void personalizarBotones() {
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);
        botonNormal2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormal2.setBackground(null);
        toggle.setBackground(null);

            toggle.setGraphic((new ImageView((new Image(getClass().getResourceAsStream("switchon.png"))))));

    }

    private void acciones() {
        // acciones
        // directa setOnEvento setOnAction --> EventHander<ActionEvent>
        //Dar accion al botonListas
        botonListas.setOnAction(new ManejoPulsaciones());
        //Spinner
        spinner.getValueFactory().valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                System.out.println(t1);
            }
        });
        //Escuchar cambio de seleccion del combo y el choice
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println(t1);
            }
        });

        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario t1) {
                t1.mostrarDatos();
            }
        });

        botonMostrar.setOnAction(new ManejoPulsaciones());
        botonOcultar.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println(((RadioButton)t1).getText());
            }
        });
        botonCalcular.setOnAction(new ManejoPulsaciones());
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormal2.setOnAction(new ManejoPulsaciones());

        toggle.setOnAction(new ManejoPulsaciones());

        toggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean oldValue, Boolean newValue) {
                if(newValue){
                    toggle.setGraphic((new ImageView((new Image(getClass().getResourceAsStream("switchoff.png"))))));}
                else {
                    toggle.setGraphic((new ImageView((new Image(getClass().getResourceAsStream("switchon.png"))))));}
                botonNormal.setDisable(toggle.isSelected());
                botonNormal2.setDisable(toggle.isSelected());
            }
        });

        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        botonNormal2.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal2.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
    }

    private void instancias(){
        listaListView=FXCollections.observableArrayList();
        listaListView.addAll(
                new Usuario("1","1","correo1@correo.com",1),
                new Usuario("2","2","correo2@correo.com",2),
                new Usuario("3","3","correo3@correo.com",3),
                new Usuario("4","4","correo4@correo4.com",4),
                new Usuario("5","5","correo4@correo.com",5),
                new Usuario("6","6","correo4@correo.com",6)
        );
        listaSpinner=FXCollections.observableArrayList();
        listaSpinner.addAll(1,2,3,4,5,6,7,8,9,10);
        listaUsuarios=FXCollections.observableArrayList();
        listaUsuarios.addAll(
                new Usuario("1","1","correo1@correo.com",1),
                new Usuario("2","2","correo2@correo.com",2),
                new Usuario("3","3","correo3@correo.com",3),
                new Usuario("4","4","correo4@correo.com",4)
                );
        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll("OpcionCh1","OpcionCh2","OpcionCh3","OpcionCh4");
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("OpcionCb1","OpcionCb2","OpcionCb3","OpcionCb4");
        sombraExterior=new DropShadow();
        grupoRadios=new ToggleGroup();
        //Para sacar los elementos de dentro del toggleGroup
        grupoRadios.getToggles().addAll(radioUno,radioDos,radioTres);
    }

    class ManejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button) mouseEvent.getSource()).setEffect(sombraExterior);
                System.out.println("raton dentro");
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) mouseEvent.getSource()).setEffect(null);
                System.out.println("raton fuera");
            }
        }
    }
    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == toggle) {
                botonNormal.setDisable(toggle.isSelected());
                botonNormal2.setDisable(toggle.isSelected());
            } else if (actionEvent.getSource() == botonNormal) {
                toggle.setSelected(true);
            } else if (actionEvent.getSource() == botonNormal2) {
                toggle.setSelected(false);
            } else if(actionEvent.getSource() == botonCalcular){
                if((RadioButton)grupoRadios.getSelectedToggle() != null && !textoOperar.getText().equals("")) {
                    //Comprobar que hay radio y cosas en el texto
                    RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                    //System.out.println(radioSeleccionado.getText());
                    CambioBase cambioBase = (CambioBase) radioSeleccionado.getUserData();
                    cambioBase.setNumeroDecimal(Integer.valueOf(textoOperar.getText()));
                    //realizar el cambio de base
                    cambioBase.cambioBase();
                   // textoOperar.setText(cambioBase.getNumeroConv());
                    System.out.println("El número "+textoOperar.getText()+" en base "+cambioBase.getBase()+" es: "+cambioBase.getNumeroConv());
                    //base 2 numeroCambio numeroDecimal = 0
                    //base 8 numeroCambio numeroDecimal = 0
                    //base 16 numeroCambio numeroDecimal = 0
                }
            } else if (actionEvent.getSource()== botonMostrar){
                //panelVisible.setVisible(true);
                panelGeneral.setLeft(panelVisible);
            } else if (actionEvent.getSource()== botonOcultar){
                //quitar pane
                //panelVisible.setVisible(false);
                panelGeneral.getChildren().remove(panelVisible);
            } else if(actionEvent.getSource() == botonListas){
                //Sacar los elementos seleccionados
                if(combo.getSelectionModel().getSelectedIndex() > -1 &&
                        choice.getSelectionModel().getSelectedIndex() >-1 &&
                        lista.getSelectionModel().getSelectedIndex()> -1){
                    System.out.println(combo.getSelectionModel().getSelectedItem());
                    choice.getSelectionModel().getSelectedItem().mostrarDatos();
                    System.out.println(spinner.getValueFactory().getValue());
                    lista.getSelectionModel().getSelectedItem().mostrarDatos();
                    listaListView.add(new Usuario("Nuevo","Nuevo","correo@correo",7));
                    //listaListView.remove(0);
                    for (int i = 0; i < listaListView.size(); i++) {
                        if(listaListView.get(i).getCorreo().equals("correo@correo4.com"))
                        {
                            listaListView.remove(i);
                        }
                    }
                }
            }
        }
    }

}
