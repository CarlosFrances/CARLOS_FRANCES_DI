//TODO: METODO DE DESCARTAR COMPLETADO. QUEDA ROBAR Y PASAR
import model.Carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Entrada {

/*- Cada jugador se le repartes 10 cartas al azar la baraja española
(10 objetos de la clase Carta donde cada uno tiene valor y palo que previamente tienen que estar barajadas).

- Una vez los jugadores tienen todas las cartas se dan dos turnos de juego y cada jugador puede
- Descartase de entre 1 y 3 cartas: selecciona el número de cartas (y cuales) y se le reparten cartas aleatorias
- Robar al rival entre 1 y 3 cartas y les devuelves la misma cantidad
- Pasar

- Cuando se pasan los turnos se decidirá cual es el ganador:
- Ganará aquel jugador que tenga más cartas del mismo palo ordenadas

Para el ejercicio tendrás que:

Crear un arraylist y rellenarlo automáticamente
Montar un menú para que pueda is dandose la mecánica del juego
Ves mostrando las cartas de cada jugador, reparticiones, etc ... en todo momento*/

    public static void main(String[] args) {
        //Crear baraja y barajar
        Carta carta=new Carta();
        carta.generarBaraja();

        ArrayList<Carta> baraja=carta.getBaraja();
        Collections.shuffle(baraja);

        //Repartir 10 cartas a cada jugador y ordenar su mano
        int cartasARobar=10;
        ArrayList<Carta> mano1=new ArrayList<>();
        ArrayList<Carta> mano2=new ArrayList<>();
        for (int i = 0; i < cartasARobar; i++) {
            mano1.add(baraja.get(0));
            baraja.remove(0);
            mano2.add(baraja.get(0));
            baraja.remove(0);
        }
        carta.ordenarMano(mano1);
        carta.ordenarMano(mano2);

        //Comienza la partida. Los turnos se suceden hasta llegar al
        //segundo turno de cada jugador
        carta.start(mano1,mano2);

        //Una vez acabado el juego, se cuentan los puntos
        // y se decide el ganador
        carta.contarPuntos(mano1,mano2);

        System.out.println("\n---------------------------RESULTADO---------------------------");
        System.out.println("Jugador 1: "+mano1.toString());
        System.out.println("Jugador 2: "+mano2.toString());
        if(carta.getPuntos1() > carta.getPuntos2()){
            System.out.println("\nGANA JUGADOR 1 CON "+carta.getPuntos1()+" puntos");
        } else if(carta.getPuntos1() < carta.getPuntos2()){
            System.out.println("\nGANA JUGADOR 2 CON "+carta.getPuntos2()+" puntos");
        } else System.out.println("\nHA HABIDO UN EMPATE A "+carta.getPuntos1()+" puntos");
    }

}
