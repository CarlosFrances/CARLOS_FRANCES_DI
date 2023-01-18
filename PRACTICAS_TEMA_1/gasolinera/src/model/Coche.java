package model;

public class Coche {

    private String tipoGasolina;
    private  int litrosDeposito;

    public Coche(String tipoGasolina){
        this.tipoGasolina=tipoGasolina;
        this.litrosDeposito=0;
    }

    public void ponerGasolina(Surtidor surtidor,int litros){
        if(surtidor.isFuncionamiento()==false) {
            System.out.println("Surtidor averiado");
            return;
        }
        if(litros > surtidor.getCapacidadActual() || surtidor.getCapacidadActual()==0) {
            System.out.println("Surtidor vacío");
            return;
        }
        if(tipoGasolina!= surtidor.getTipoGasolina()) {
            System.out.println("Surtidor equivocado");
            return;
        }
        surtidor.quitarGasolina(litros);
        this.litrosDeposito+=litros;
        System.out.println("Has repostado "+litros+" litros de "+tipoGasolina);
    }



}
