package model;

public class Coche {

    //PROPIEDADES --> siempre private -->por el ENCAPSULAMIENTO
    private String marca, modelo, bastidor;
    private int cv;
    private double cc;
    private int velocidad, kg;

    // constructores() --> tengo 1 por defecto () --> si quieres más, debes escribirlos


    // marca, modelo

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // marca,modelo, cv, cc

    public Coche(String marca, String modelo, int cv, double cc) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
    }

    // marca,modelo, cv, cc, bastidor

    public Coche(String marca, String modelo, int cv, double cc, String bastidor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
        this.bastidor = bastidor;
    }


    // métodos --> funcionalidades del objeto
    public void acelerar(int velocidad){
        //si los cv son superiores a 150, incrementar en un 20% la velocidad del parametro
        if(this.cv > 150)
            this.velocidad = velocidad + (int)(velocidad*1.2);
        else this.velocidad += velocidad;
    }

    public boolean decelerar(int velocidad){
        if(velocidad >= this.velocidad){
            this.velocidad=0; return false;
        } else{
            this.velocidad-=velocidad;
            return true;}
    }
    // getter y setter


    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", bastidor='" + bastidor + '\'' +
                ", cv=" + cv +
                ", cc=" + cc +
                ", velocidad=" + velocidad +
                ", kg=" + kg +
                '}';
    }
}
