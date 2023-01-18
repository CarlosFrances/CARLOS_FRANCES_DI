package com.example.t4_json.model;

public class Persona {

    private String nombre,correo,telefono,pais,imagen;

    public Persona(String nombre, String correo, String telefono, String pais, String imagen) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.pais = pais;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Correo: "+correo+", Teléfono"+telefono+", Pais: "+pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
