package model;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Trabajador> listaTrabajadores;
    private String CIF;
    private String nombre;
    private int resultadoVotos=0;


    public Empresa(String nombre, String CIF){
        this.CIF=CIF;
        this.nombre=nombre;
        this.listaTrabajadores=new ArrayList<>();
    }

    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void registrarVoto(Votante votante, int voto){
        resultadoVotos+=votante.votar(voto);
        // listaTrabajadores --> tengo Personas
        // Todos los votantes voten, aleatorio entre 1 y 10
    }

    public void contratarTrabajador(Trabajador trabajador){
        // Solo puede contratar trabajadores que no tenga ya contratados
        // Solo pueden existir trabajadores con diferentes NSS
        if(existeTrabajador(trabajador.getNSS())==null){
            System.out.println("Trabajador añadido");
            listaTrabajadores.add(trabajador);
        }
    }

    public void listarTrabajadores(String eleccion){
        if(eleccion.equals("Trabajador")){
            for(Trabajador t:listaTrabajadores){
                    t.mostrarDatos();
            }
        }
        for(Trabajador t:listaTrabajadores){
            if(t.getClass().getSimpleName().equals(eleccion)){
                t.mostrarDatos();
            }
        }
    }

    public void buscarTrabajador(int nss){
        if(existeTrabajador(nss)!=null) {
            existeTrabajador(nss).mostrarDatos();
        }
        else System.out.println("Trabajador no encontrado");
    }

    private Trabajador existeTrabajador(int nss){

        Trabajador existe=null;

        for(Trabajador t:listaTrabajadores) {
            if (t.getNSS() == nss) {
                System.out.println("El NSS ya exixte");
                existe =t;
            }
        }
        return existe;
    }
}
