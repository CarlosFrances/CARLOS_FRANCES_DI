package model;

import java.util.ArrayList;

public class Medico extends Persona{

    private int numeroColegiado;
    private String especialidad;
    private ArrayList<Cita> citas=new ArrayList<>();

    public Medico(String nombre, String apellido, String especialidad, String DNI, int numeroColegiado,ArrayList<Cita> citas) {
        super(nombre,apellido,DNI);
        this.numeroColegiado = numeroColegiado;
        this.especialidad = especialidad;
        this.citas=citas;
    }

    @Override
    public String toString() {
        return "Dr "+nombre+
                " "+apellido+", "+
                especialidad+", "+
                numeroColegiado+", "+
                especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
}
