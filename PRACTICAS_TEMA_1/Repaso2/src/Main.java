import model.Coche;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Coche (marca="Mercedes",modelo="C220",cv=0;cc=0.0,bastidor=null)
        Coche coche1=new Coche("Mercedes","C220");
        // Coche (marca="Mercedes",modelo="C300",cv="300",cc=3.0,bastidor=null,vel=0,km=0)
        Coche coche2=new Coche("C300","Mercedes",300,3.0);
        Coche coche3=new Coche("A5","Audi",200,3.0);
        Coche coche4=new Coche("A3","Audi",150,2.0);

        ArrayList<Coche> listaCoches =new ArrayList<Coche>();
        listaCoches.add(coche1);
        listaCoches.add(coche2);
        listaCoches.add(coche3);
        listaCoches.add(coche4);



        coche1.setCv(175);

        coche1.acelerar(100);
        coche2.acelerar(100);
        coche2.acelerar(20);
        coche1.acelerar(50);

        System.out.println(coche1);
        System.out.println(coche2);

        if(!coche1.decelerar(190)){
            System.out.println("Ha ocurrido algo, frenazo en seco");
        }
        System.out.println(coche1);

        double media=0;
        for (Coche coche : listaCoches) {
            media+=coche.getCv();
        }
        media/=listaCoches.size();
        System.out.println("La media de caballos es: "+media);

    }
}
