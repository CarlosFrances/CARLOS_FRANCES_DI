package com.example.pr_pestanias_2.model;

public class Abonado {

    private int edad;
    private String localidad,equipo,sexo;

    public Abonado(int edad, String localidad, String equipo, String sexo) {
        this.edad = edad;
        this.localidad = localidad;
        this.equipo = equipo;
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Equipo: "+equipo+" - Edad: "+edad+" - Localidad: "+localidad+" - Sexo: "+sexo;
    }
}
