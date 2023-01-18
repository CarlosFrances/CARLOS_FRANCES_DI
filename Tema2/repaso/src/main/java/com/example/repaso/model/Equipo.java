package com.example.repaso.model;

public class Equipo {
    private String nombre,imagen,campo;

    public Equipo(String nombre, String imagen, String campo) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.campo = campo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}
