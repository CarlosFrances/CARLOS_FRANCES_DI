package model;

public class Surtidor {

    private int capacidadTotal;
    private int capacidadActual;
    private String tipoGasolina;
    private boolean funcionamiento;

    public Surtidor(int capacidadTotal,String tipoGasolina){
        this.capacidadTotal=capacidadTotal;
        this.tipoGasolina=tipoGasolina;
        this.funcionamiento=true;
        this.capacidadActual=capacidadTotal;
    }

    public Surtidor(String tipoGasolina){
        this.tipoGasolina=tipoGasolina;
        this.funcionamiento=false;
        this.capacidadActual=0;
        this.capacidadTotal=0;
    }

    public void arreglar (){
        this.funcionamiento=true;
    }

    public void averiar(){this.funcionamiento=false;}

    public void rellenar(int litros){
        this.capacidadActual+=litros;
    }

    public void quitarGasolina(int litros){
        this.capacidadTotal-=litros;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public boolean isFuncionamiento() {
        return funcionamiento;
    }

    public void setFuncionamiento(boolean funcionamiento) {
        this.funcionamiento = funcionamiento;
    }
}
