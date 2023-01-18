package model;

public class Entrada {




    public static void main(String[] args) {
        Coche cocheA=new Coche();
        Coche cocheB=new Coche("307","0307CSS",50);

        cocheA.setModelo("Zafira");
        cocheA.setMatricula("4567MN");
        cocheA.setCv(60);
        cocheA.setVelocidad((int)(Math.random()*21+10));
        cocheB.setVelocidad((int)(Math.random()*21+10));

        cocheA.mostrarDatos();
        cocheB.mostrarDatos();

        do{
            cocheA.acelerar(10);
            cocheB.acelerar(10);

        }while(cocheA.getKm()<cocheA.getKILOMETROSETAPA() ||
                cocheB.getKm()<cocheA.getKILOMETROSETAPA());

        if(cocheA.getKm()>cocheB.getKm())
            System.out.println("El ganador es: "+cocheA.getModelo()+
                    " con "+cocheA.getKm()+" Km recorridos");
        else if(cocheA.getKm()<cocheB.getKm())
            System.out.println("El ganador es: "+cocheB.getModelo()+
                    " con "+cocheB.getKm()+" Km recorridos");
        else System.out.println("Ha habido un empate a "+cocheA.getKm()+" Km recorridos");


    }
}
