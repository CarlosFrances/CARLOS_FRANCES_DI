package com.example.carlosfrancesexamen.model;

import java.util.ArrayList;

public class Pedido {

    private String nombre,telefono;
    private int id;
    private int precio=0;
    private ArrayList<String> pizzas;

    public Pedido(String nombre, String telefono, int id, ArrayList<String> pizzas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;
        this.pizzas = pizzas;
    }

    private int calcularPrecio(){
        for(int i = 0; i < pizzas.size();i++){
            if(pizzas.get(i).equals("Barbacoa"))  precio+=12;
            else if(pizzas.get(i).equals("Hawaiana") || pizzas.get(i).equals("Jamon y queso")) precio+=10;
            else if(pizzas.get(i).equals("Cuatro quesos")) precio+=17;
            else if(pizzas.get(i).equals("Carbonara")) precio+=10;
        }
        return precio;
    }

    private String printPizzas(){
        String s="";
        for(int i=0;i<pizzas.size();i++){
            if(i== pizzas.size()-1) s+=pizzas.get(i);
            else s+=pizzas.get(i)+",\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return "Pedido ID: "+id+"\nNombre: "+nombre+"\nTeléfono: "+telefono+"\nPizzas: "+printPizzas()+"\nPrecio: "+calcularPrecio()+"\nEntregado";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<String> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<String> pizzas) {
        this.pizzas = pizzas;
    }
}
