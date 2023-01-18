package model;

import java.util.ArrayList;

public class Paciente extends Persona{

    private int nss;
    private ArrayList<CitaPaciente> listaCitas;//null

    public Paciente(String dni, String nombre, String apellido,int nss) {
        super(dni, nombre, apellido);
        this.nss=nss;
        this.listaCitas=new ArrayList<>();
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("NSS: "+nss);
        if(!listaCitas.isEmpty()){
            for(CitaPaciente item:listaCitas){
                item.mostrarDatos();
            }
        }
    }
}
