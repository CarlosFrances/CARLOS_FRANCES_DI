package com.example.carlosfrancesexamen;

import com.example.carlosfrancesexamen.model.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //userTextField.setPromptText("name");

    @FXML
    private TextField textoNombre,textoTelefono;

    @FXML
    private Button botonAgregar,botonFinalizar,botonEntregar;

    @FXML
    private ChoiceBox<String> choice;
    private ObservableList<String> listaChoice;
    @FXML
    private ListView<String> listProvisional,listPedidos;
    private ObservableList<String> listaPedidosProvisionales,listaPedidos;

    private int contadorPedidos=0;
    private ArrayList<Pedido> pedidos=new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        asociarDatos();
        acciones();
    }

    private void initGUI() {
        textoNombre.setPromptText("Introduzca su nombre");
        textoTelefono.setPromptText("Introduzca su teléfono");
    }

    private void acciones() {
        //Boton agregar
        botonAgregar.setOnAction(new ManejoPulsaciones());
        botonFinalizar.setOnAction(new ManejoPulsaciones());
        botonEntregar.setOnAction(new ManejoPulsaciones());
    }

    private void asociarDatos() {
        listPedidos.setItems(listaPedidos);
        listProvisional.setItems(listaPedidosProvisionales);

        choice.setItems(listaChoice);
    }

    private void instancias() {
        listaPedidos = FXCollections.observableArrayList();
        listaPedidosProvisionales = FXCollections.observableArrayList();

        listaChoice=FXCollections.observableArrayList();
        listaChoice.addAll("Barbacoa","Hawaiana","Jamon y queso","Cuatro quesos","Carbonara");
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == botonAgregar){
                if(choice.getSelectionModel().getSelectedIndex() > -1){
                    listaPedidosProvisionales.add(choice.getSelectionModel().getSelectedItem());
                }else System.out.println("Seleccione una pizza");
            }
            else if(actionEvent.getSource() == botonFinalizar){
                if(!textoNombre.getText().equals("") && !textoTelefono.getText().equals("")){
                    if(!listaPedidosProvisionales.isEmpty()){
                        contadorPedidos++;
                        listaPedidos.add(contadorPedidos+" - "+textoNombre.getText());
                        ArrayList<String> pizzas=new ArrayList<>();
                        for (int i=0;i<listaPedidosProvisionales.size();i++){
                            pizzas.add(i,listaPedidosProvisionales.get(i));
                        }
                        pedidos.add(new Pedido(textoNombre.getText(),textoTelefono.getText(),contadorPedidos,pizzas));
                        //Reiniciar valores
                        listaPedidosProvisionales.clear();
                        textoNombre.setText("");
                        textoTelefono.setText("");
                        choice.getSelectionModel().select("Barbacoa");
                        //
                    } else System.out.println("Agregue una pizza al pedido");
                }else System.out.println("Rellene sus datos personales");
            }
            else if(actionEvent.getSource() == botonEntregar){
                int sel=listPedidos.getSelectionModel().getSelectedIndex();
                if(sel>-1){
                    listaPedidos.remove(sel);
                    System.out.println(pedidos.get(sel));
                    pedidos.remove(sel);
                }else System.out.println("Seleccione un pedido a entregar");
            }
        }
    }
}