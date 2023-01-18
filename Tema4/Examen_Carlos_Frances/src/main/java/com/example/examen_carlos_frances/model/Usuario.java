package com.example.examen_carlos_frances.model;

public class Usuario {

    private String nombre,password,correo,telefono,perfil;

    public Usuario(String nombre, String password, String correo, String telefono, String perfil) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
        this.perfil = perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
