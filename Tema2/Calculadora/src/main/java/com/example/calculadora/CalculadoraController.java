    package com.example.calculadora;

    import javafx.beans.value.ChangeListener;
    import javafx.beans.value.ObservableValue;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextArea;
    import javafx.scene.control.TextField;
    import javafx.scene.control.ToggleButton;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.GridPane;

    import java.net.URL;
    import java.util.ResourceBundle;

    public class CalculadoraController implements Initializable {
    @FXML
    private Button b0;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button bAC;

    @FXML
    private Button bCerrarCientifica;

    @FXML
    private ToggleButton bCientifica;

    @FXML
    private Button bCoseno;

    @FXML
    private Button bDivision;

    @FXML
    private Button bC;

    @FXML
    private Button bExponente;

    @FXML
    private Button bIgual;

    @FXML
    private Button bLogaritmo;

    @FXML
    private Button bPunto;

    @FXML
    private Button bMultiplicacion;

    @FXML
    private Button bMasMenos;

    @FXML
    private Button bRaiz;

    @FXML
    private ToggleButton bRegistro;

    @FXML
    private Button bResta;

    @FXML
    private Button bResto;

    @FXML
    private Button bSeno;

    @FXML
    private Button bSuma;

    @FXML
    private GridPane panelDerecha;

    @FXML
    private TextArea textoRegistro;

    @FXML
    private BorderPane panelGeneral;

    @FXML
    private GridPane panelIzquierda;

    @FXML
    private TextField textoResultado;

    @FXML
    private Button bTangente;


    //Variables
        private double num1 = 0;
        private double num2 = 0;
        private double res = 0;
        private String oper="";
        private String historial="";

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            initGUI();
            acciones();
        }

        private void acciones() {
            b0.setOnAction(new ManejoPulsaciones());
            b1.setOnAction(new ManejoPulsaciones());
            b2.setOnAction(new ManejoPulsaciones());
            b3.setOnAction(new ManejoPulsaciones());
            b4.setOnAction(new ManejoPulsaciones());
            b5.setOnAction(new ManejoPulsaciones());
            b6.setOnAction(new ManejoPulsaciones());
            b7.setOnAction(new ManejoPulsaciones());
            b8.setOnAction(new ManejoPulsaciones());
            b9.setOnAction(new ManejoPulsaciones());
            bPunto.setOnAction(new ManejoPulsaciones());
            bSuma.setOnAction(new ManejoPulsaciones());
            bResta.setOnAction(new ManejoPulsaciones());
            bMultiplicacion.setOnAction(new ManejoPulsaciones());
            bDivision.setOnAction(new ManejoPulsaciones());
            bIgual.setOnAction(new ManejoPulsaciones());
            bAC.setOnAction(new ManejoPulsaciones());
            bC.setOnAction(new ManejoPulsaciones());
            bMasMenos.setOnAction(new ManejoPulsaciones());
            bResto.setOnAction(new ManejoPulsaciones());
            bRaiz.setOnAction(new ManejoPulsaciones());
            bExponente.setOnAction(new ManejoPulsaciones());
            bSeno.setOnAction(new ManejoPulsaciones());
            bCoseno.setOnAction(new ManejoPulsaciones());
            bTangente.setOnAction(new ManejoPulsaciones());
            bLogaritmo.setOnAction(new ManejoPulsaciones());
            //boton de ocultar cientifica
            bCerrarCientifica.setOnAction(new ManejoPulsaciones());

            //Toggles de cientifica y registro
            bCientifica.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                    if(t1)panelGeneral.setLeft(panelIzquierda);
                    else panelGeneral.getChildren().remove(panelIzquierda);
                }
            });
            bRegistro.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                    if(t1)panelGeneral.setRight(panelDerecha);
                    else panelGeneral.getChildren().remove(panelDerecha);
                }
            });
        }

        private void initGUI() {
            panelGeneral.getChildren().remove(panelDerecha);
            panelGeneral.getChildren().remove(panelIzquierda);
        }

        private void clickBoton(int i) {
            if(res != 0)return;
            textoResultado.setText(textoResultado.getText()+String.valueOf(i));
        }

        private void addRegistro() {
            if(oper.equals("sin") || oper.equals("cos") || oper.equals("tan")){
                if(oper.equals("sin"))historial+="Sin("+num1+") = "+res;
                else if(oper.equals("cos"))historial+="Cos("+num1+") = "+res;
                else historial+="Tan("+num1+") = "+res;
            }
            else historial+=num2+" = "+res;
            textoRegistro.appendText(historial+"\n");
            historial="";
            oper="";
        }

        private void elegirOperacion(String operador) {
            if(textoResultado.getText().equals("")) return;
            num1 = Double.parseDouble(textoResultado.getText());
            res=0;
            oper = operador;
            historial+=num1+" "+operador+" ";
            textoResultado.setText("");
        }

        private void calcularSinCos(String operador){
            if(textoResultado.getText().equals(""))return;
            num1 = Double.parseDouble(textoResultado.getText());
            res=0;
            oper=operador;
        }

        private void resultadoAInt() {
            int i=0;
            if(res % 1 == 0) {
                i = (int)res;
                textoResultado.setText(String.valueOf(i));
            }else textoResultado.setText(String.valueOf(res));
        }

        private class ManejoPulsaciones implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent a) {
                if(a.getSource() == bCerrarCientifica){
                    bCientifica.setSelected(!bCientifica.isSelected());
                }else if(a.getSource() == b0){
                    clickBoton(0);
                }else if(a.getSource() == b1){
                    clickBoton(1);
                }else if(a.getSource() == b2){
                    clickBoton(2);
                }else if(a.getSource() == b3){
                    clickBoton(3);
                }else if(a.getSource() == b4){
                    clickBoton(4);
                }else if(a.getSource() == b5){
                    clickBoton(5);
                }else if(a.getSource() == b6){
                    clickBoton(6);
                }else if(a.getSource() == b7){
                    clickBoton(7);
                }else if(a.getSource() == b8){
                    clickBoton(8);
                }else if(a.getSource() == b9){
                    clickBoton(9);
                }else if(a.getSource() == bPunto){
                    if(textoResultado.getText().contains(".") ||
                        textoResultado.getText().equals("")) return;
                    textoResultado.setText(textoResultado.getText()+".");
                }else if(a.getSource() == bSuma){
                    elegirOperacion("+");
                }else if(a.getSource() == bResta){
                    elegirOperacion("-");
                }else if(a.getSource() == bMultiplicacion){
                    elegirOperacion("*");
                }else if(a.getSource() == bDivision){
                    elegirOperacion("/");
                }else if(a.getSource() == bResto){
                    elegirOperacion("%");
                }else if(a.getSource() == bExponente){
                    elegirOperacion("^");
                }else if(a.getSource() == bRaiz){
                    elegirOperacion("√");
                }else if(a.getSource() == bLogaritmo){
                    elegirOperacion("log");
                }else if(a.getSource() == bIgual){
                    if(num1 == 0 || textoResultado.getText().equals("")) return;
                    num2 = Double.parseDouble(textoResultado.getText());
                    switch (oper){
                        case"+":res=num1+num2;addRegistro();break;
                        case"-":res=num1-num2;addRegistro();break;
                        case"*":res=num1*num2;addRegistro();break;
                        case"/":res=num1/num2;addRegistro();break;
                        case"%":res=num1%num2;addRegistro();break;
                        case"^":res=Math.pow(num1,num2);addRegistro();break;
                        case"√":res=Math.pow(num1,1 / num2);addRegistro();break;
                        case"log":res=Math.log(num1) / Math.log(num2);addRegistro();break;
                        case"sin":res=Math.sin(num1);addRegistro();break;
                        case"cos":res=Math.cos(num1);addRegistro();break;
                        case"tan":res=Math.tan(num1);addRegistro();break;
                    }
                    resultadoAInt();
                    num1=res;
                }else if(a.getSource() == bAC){
                    textoResultado.setText("");num1=0;num2=0;res=0;
                }else if(a.getSource() == bC){
                    StringBuffer s = new StringBuffer(textoResultado.getText());
                    s.deleteCharAt(s.length()-1);
                    String str = s.toString();
                    textoResultado.setText(str);
                }else if(a.getSource() == bMasMenos){
                    if(textoResultado.getText().equals(""))return;
                    double num = Double.parseDouble(textoResultado.getText());
                    num-=num*2;
                    textoResultado.setText(Double.toString(num));
                }else if(a.getSource() == bSeno){
                    calcularSinCos("sin");
                }else if(a.getSource() == bCoseno){
                    calcularSinCos("cos");
                }else if(a.getSource() == bTangente){
                    calcularSinCos("tan");
                }
            }
        }

    }