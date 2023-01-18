package model;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Carta{

    Scanner scanner=new Scanner(System.in);
    private int contadorTurno=1;

    private int puntos1;
    private int puntos2;
    private int valor;
    private String palo;

    private int id;
    private final int NUMEROMAXIMO=13;
    private int[] numeros={1,2,3,4,5,6,7,8,9,10,11,12,13};


    public Carta(int valor, String palo,int id){
        this.valor=valor;
        this.palo=palo;
        this.id=id;
    }

    public Carta(){}

    private ArrayList<Carta> baraja=new ArrayList<>();

    //Cada carta se crea con un valor, palo e ID, el cual ayudará a
    //ordenar la mano y a contar los puntos
    public void generarBaraja(){
        int id=1;
        for (int i = 1; i < NUMEROMAXIMO+1; i++) {
            Carta carta=new Carta(i,"C",id);
            baraja.add(carta);
            id++;
        }
        id++;
        for (int i = 1; i < NUMEROMAXIMO+1; i++) {
            Carta carta=new Carta(i,"D",id);
            baraja.add(carta);
            id++;
        }
        id++;
        for (int i = 1; i < NUMEROMAXIMO+1; i++) {
            Carta carta=new Carta(i,"P",id);
            baraja.add(carta);
            id++;
        }
        id++;
        for (int i = 1; i < NUMEROMAXIMO+1; i++) {
            Carta carta=new Carta(i,"T",id);
            baraja.add(carta);
            id++;
        }
    }

    //La mano se ordena gracias a la propiedad "ID" de las cartas
    public void ordenarMano(ArrayList<Carta> mano){
        for (int i = 0; i < mano.size(); i++) {
            for (int j = 0; j < mano.size(); j++) {
                if(mano.get(i).id < mano.get(j).id){
                    Collections.swap(mano,i,j);
                }
            }
        }
    }

    //Este metodo engloba todas las posibles acciones del turno de un jugador
    //desde los print por pantalla hasta la eleccion de la accion que desea realizar
    //y los metodos que la realizan
    public void start(ArrayList<Carta> mano1,ArrayList<Carta> mano2){
        String sc;

        contadorTurno=1;
        //Se muestran las manos, de quien es el turno y se
        // le pide al usuario que elija una accion
        while(contadorTurno<5) {
            int jugador = contadorTurno%2;
            do{
                    System.out.println("JUGADOR 1: "+mano1.toString());
                System.out.println("JUGADOR 2: "+mano2.toString());

                if(jugador==1)
                    System.out.println("\nTurno del jugador 1");
                else System.out.println("\nTurno del jugador 2");
                System.out.println("Elija su acción: Descartar (D), Robar (R), Pasar (P)");
                System.out.println("- Descartar: Descartas de 1 a 3 cartas y robas la misma cantidad de la baraja");
                System.out.println("- Robar: Robas al contrincante de 1 a 3 cartas");
                System.out.println("- Pasar: Cede el turno a tu oponente");

                sc=scanner.next();
            }while(!(sc.equalsIgnoreCase("D")||
                    sc.equalsIgnoreCase("R")||
                    sc.equalsIgnoreCase("P")));

            //Dependiendo de la accion elegida, se ejecutará un metodo u otro

            switch (sc) {
                case "D":
                    this.descartar(jugador, mano1, mano2);
                    break;
                case "d":
                    this.descartar(jugador, mano1, mano2);
                    break;
                case "R":
                    this.robar(jugador, mano1, mano2);
                    break;
                case "r":
                    this.robar(jugador, mano1, mano2);
                    break;
                case "P":
                    this.pasar(jugador);
                    break;
                case "p":
                    this.pasar(jugador);
                    break;
            }
        }
    }

    //El jugador descarta de 1 a 3 cartas y roba la misma cantidad
    private void descartar(int jugador,ArrayList<Carta>mano1,ArrayList<Carta>mano2) {
        if(jugador==1)
            System.out.println("SU MANO: "+mano1.toString()+"\n");
        else System.out.println("SU MANO: "+mano2.toString()+"\n");
        System.out.println("Elija la cantidad de cartas a descartar (1 - 3): ");
        int numeroCartas=scanner.nextInt();

        for (int i = 0; i < numeroCartas; i++) {
            System.out.println("Carta número "+i);
            System.out.println("Valor: ");
            int valor= scanner.nextInt();
            System.out.println("Palo: ");
            String palo=scanner.next();

            //Se descartan las cartas que coincidan con los datos introducidos y se roba inmediatamente
            //la misma cantidad de cartas del deck. esto ocurrirá dependiendo del jugador 1 o 2
            if(jugador==1){
                for (int j = 0; j < mano1.size(); j++) {
                    if(mano1.get(j).getValor()==valor && mano1.get(j).getPalo().equalsIgnoreCase(palo)){
                        mano1.remove(j);
                        mano1.add(baraja.get(0));
                        baraja.remove(0);
                    }
                }
            }else{
                for (int j = 0; j < mano2.size(); j++) {
                    if(mano2.get(j).valor==valor && (String)mano2.get(j).palo==palo){
                        mano2.remove(j);
                        mano2.add(baraja.get(0));
                        baraja.remove(0);
                    }
                }
            }
        }

        //al final del metodo se muestra como ha quedado la mano (ordenada)
        if(jugador==1){
            ordenarMano(mano1);
            System.out.println("TU MANO: "+mano1.toString());
        }else{
            ordenarMano(mano2);
            System.out.println("TU MANO: "+mano2.toString());
        }
        this.contadorTurno++;
    }

    //El jugador elige cuantas cartas quiere robar y le entrega esa
    //misma cantidad al enemigo, del cual roba dicha cantidad de cartas
    //al azar de su mano
    public void robar(int jugador,ArrayList<Carta>mano1,ArrayList<Carta>mano2){
        int aleatorio=(int)(Math.random()*10);
        if(jugador==1)
            System.out.println("SU MANO: "+mano1.toString()+"\n");
        else System.out.println("SU MANO: "+mano2.toString()+"\n");
        System.out.println("Elija la cantidad de cartas a robar (1-3): ");
        int numeroCartas=scanner.nextInt();

        for (int i = 0; i < numeroCartas; i++) {
            System.out.println("Carta número "+i);
            System.out.println("Valor: ");
            int valor= scanner.nextInt();
            System.out.println("Palo: ");
            String palo=scanner.next();

            if(jugador==1){
                for (int j = 0; j < mano1.size(); j++) {
                    if(mano1.get(j).getValor()==valor && mano1.get(j).getPalo().equalsIgnoreCase(palo)){
                        mano2.add(mano1.get(j));
                        mano1.remove(j);
                        mano1.add(mano2.get(aleatorio));
                        mano2.remove(aleatorio);
                        this.ordenarMano(mano1);
                        this.ordenarMano(mano2);
                    }
                }
            }else{
                for (int j = 0; j < mano1.size(); j++) {
                    if(mano2.get(j).getValor()==valor && mano2.get(j).getPalo().equalsIgnoreCase(palo)){
                        mano1.add(mano2.get(j));
                        mano2.remove(j);
                        mano2.add(mano1.get(aleatorio));
                        mano1.remove(aleatorio);
                        this.ordenarMano(mano1);
                        this.ordenarMano(mano2);
                    }
                }
            }
        }

        if(jugador==1){
            ordenarMano(mano1);
            System.out.println("TU MANO: "+mano1.toString());
        }else{
            ordenarMano(mano2);
            System.out.println("TU MANO: "+mano2.toString());
        }
        this.contadorTurno++;
    }

    public void pasar(int jugador){
        if(jugador==0) System.out.println("EL JUGADOR 2 HA PASADO");
        else System.out.println("EL JUGADOR 1 HA PASADO");
        contadorTurno++;
    }

    //El algoritmo de contar puntos necesita retoques para funcionar bien
    public void contarPuntos(ArrayList<Carta> mano1,ArrayList<Carta> mano2){
        for (int i = 0; i < mano1.size()-1; i++) {
            if(i < mano1.size()-2 && mano1.get(i).getId() ==
                    (mano1.get(i+1).getId()-1)){
                puntos1++;
            }
        }
        for (int i = 0; i < mano2.size()-1; i++) {
            if(i < mano2.size()-2 && mano2.get(i).getId() ==
                    (mano2.get(i+1).getId()-1)){
                puntos2++;
            }
        }
    }


    @Override
    public String toString() {
        return valor+" "+palo;
    }

    public int getId(){
        return id;
    }

    public int getPuntos1(){
        return puntos1;
    }
    public int getPuntos2(){
        return puntos2;
    }
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public ArrayList<Carta> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<Carta> baraja) {
        this.baraja = baraja;
    }
}
