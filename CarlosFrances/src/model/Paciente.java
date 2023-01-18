package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Paciente extends Persona{

    Scanner scan=new Scanner(System.in);
    private int NSS;
    private ArrayList<Cita> citas=new ArrayList<>();

    public Paciente(){
        super("","","");
        this.NSS=NSS;
        this.citas=citas;
    }

    public Paciente(String nombre, String apellido,int NSS, String DNI,ArrayList<Cita> citas) {
        super(nombre, apellido, DNI);
        this.NSS=NSS;
        this.citas=citas;
    }

    public Paciente(String nombre, String apellido,int NSS, String DNI) {
        super(nombre, apellido, DNI);
        this.NSS=NSS;
    }

    public void addCita(Cita cita){
        citas.add(cita);
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
}
