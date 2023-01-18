package model;

abstract public class Persona {

    String nombre;
    String apellido;
    String DNI;

    public Persona(String nombre, String apellido, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }
}
