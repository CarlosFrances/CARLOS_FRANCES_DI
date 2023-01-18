package com.example.pokeapi.model;

import java.util.ArrayList;

public class Pokemon {

    private String nombre,sprite;
    private ArrayList<String> movimientos;
    private ArrayList<String> tipos;

    private int numero;

    public Pokemon(String nombre,int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
    public Pokemon(String nombre,int numero,String sprite){
        this.nombre = nombre;
        this.numero = numero;
        this.sprite=sprite;
    }

    public Pokemon(String nombre,int numero,String sprite, ArrayList<String> tipos){
        this.nombre = nombre;
        this.numero = numero;
        this.sprite=sprite;
        this.tipos=tipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<String> movimientos) {
        this.movimientos = movimientos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero+" - "+nombre;
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }
}
