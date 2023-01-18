package model;

import java.util.ArrayList;

public class Medico extends Persona{

    private int nColegiado;
    private String especialidad;
    private ArrayList<String> listaCitas;

    public Medico(String dni, String nombre, String apellido, int nColegiado,String especialidad) {
        super(dni, nombre, apellido);
        this.nColegiado=nColegiado;
        this.especialidad=especialidad;
    }

    public void registrarCita(int dia,int mes){
        listaCitas.add(dia+"/"+mes);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Numero de colegiado: "+nColegiado);
        System.out.println("Especialidad: "+especialidad);
        if(!listaCitas.isEmpty()){
            System.out.println("Citas registradas: "+especialidad);
            for(String item:listaCitas){
                System.out.println("Dia: "+item.split("-")[0]);
                System.out.println("Mes: "+item.split("-")[1]);
            }
        }
    }

    public int getnColegiado() {
        return nColegiado;
    }

    public void setnColegiado(int nColegiado) {
        this.nColegiado = nColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<String> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<String> listaCitas) {
        this.listaCitas = listaCitas;
    }
}
