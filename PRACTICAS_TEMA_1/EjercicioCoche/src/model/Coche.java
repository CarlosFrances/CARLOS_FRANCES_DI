package model;

public class Coche {

    //ATRIBUTOS
    private int cv,velocidad;
    private String matricula,modelo;
    private double km;

    private final int KILOMETROSETAPA=10000;
    public int getKILOMETROSETAPA(){
        return KILOMETROSETAPA;
    }

    //CONSTRUCTORES
    public Coche(){
        this.cv=0;
        this.velocidad=0;
        this.matricula="0000AAA";
        this.modelo="Sin especificar";
        this.km=0.0;
    }

    public Coche(String modelo,String matricula, int cv){
        this.cv=0;
        this.velocidad=0;
        this.km=0.0;
        this.modelo=modelo;
        this.matricula=matricula;
        this.cv=cv;
    }

    //GETTER Y SETTER


    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    //METODOS
    public void acelerar(int velocidad){
        this.velocidad+=velocidad;
        if(this.velocidad>180) {
            System.out.println("No puedes superar los 180 km/h");
            this.velocidad=180;
        }
        setKm(this.getKm()+this.velocidad*((this.getCv()/10)*((int)(Math.random()*10+1))));
    }

    public void frenar(int velocidad){
        this.velocidad-=velocidad;
        if(this.velocidad<0){
            this.velocidad=0;
            System.out.println("Velocidad fijada a 0");
        }
    }

    public void parar(){
        this.velocidad=0;
    }

    public void resetear(){
        this.velocidad=0;
        this.km=0;
    }

    public void mostrarDatos(){
        System.out.println("Matrícula: "+this.matricula+" Modelo: "+this.modelo+
                " CV: "+this.cv+" Velocidad: "+this.velocidad+" Kilómetros: "+this.km);
    }


}
