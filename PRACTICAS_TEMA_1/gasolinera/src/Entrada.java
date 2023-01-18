import model.Gasolinera;
import model.Surtidor;
import model.Coche;

import java.util.ArrayList;

public class Entrada {



    public static void main(String[] args) {
        Surtidor surtidor1=new Surtidor(100,"gasolina95");
        Surtidor surtidor2=new Surtidor(50,"gasolina98");
        Surtidor surtidor3=new Surtidor("diesel");

        Gasolinera gasolinera=new Gasolinera("Cepsa");

        ArrayList<Surtidor> surtidores=new ArrayList<Surtidor>();
        surtidores.add(surtidor1);
        surtidores.add(surtidor2);
        surtidores.add(surtidor3);

        gasolinera.setSurtidores(surtidores);

        Coche coche=new Coche("gasolina95");

        //Repostaje correcto
        coche.ponerGasolina(surtidor1,50);
        //Surtidor vacio
        coche.ponerGasolina(surtidor1,110);
        //Surtidor equivocado
        coche.ponerGasolina(surtidor2,20);
        //Surtidor averiado
        surtidor2.averiar();
        coche.ponerGasolina(surtidor2,10);

    }

}
