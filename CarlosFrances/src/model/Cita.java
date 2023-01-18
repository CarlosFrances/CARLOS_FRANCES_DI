package model;

public class Cita {

    private int dia;
    private int mes;

    public Cita(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Dia: "+dia+" mes: "+mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}
