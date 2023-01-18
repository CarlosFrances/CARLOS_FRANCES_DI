package model;

public class Persona {

    private String nombre,DNI,sexo;
    private double peso,altura;
    private int edad;

    public Persona(){
        this.nombre="defecto";
        this.DNI="defecto";
        this.sexo="defecto";
        this.peso=0.0;
        this.altura=0.0;
        this.edad=0;
    }

    public Persona(String nombre,int edad,String sexo){
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
        this.DNI="defecto";
        this.altura=0.0;
        this.peso=0.0;
    }

    public Persona(String nombre,String DNI,String sexo,
                   double peso,double altura,int edad){
        this.nombre=nombre;
        this.DNI=DNI;
        this.sexo=sexo;
        this.peso=peso;
        this.altura=altura;
        this.edad=edad;
    }

    public int calcularIMC(){
        int imc= (int) (peso/(Math.pow(altura,2)));

        if(imc<20) return -1;
        else if(imc >= 20 && imc <=25) return 0;
        else return 1;
    }

    public void mensajeImc(int imc){
        if(imc==-1) System.out.println("Infrapeso");
        if(imc==0) System.out.println("Peso ideal");
        if(imc==1) System.out.println("Sobrepeso");
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", sexo='" + sexo + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", edad=" + edad +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
