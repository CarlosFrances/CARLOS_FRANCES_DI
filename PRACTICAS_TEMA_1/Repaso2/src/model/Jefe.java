package model;

public final class Jefe extends Trabajador implements Votante{

    private char nivelResponsabilidad;

    public Jefe(String nombre, String apellido, String dni, int NSS,char nivelResponsabilidad) {
        super(nombre, apellido, dni, NSS);
        this.nivelResponsabilidad=nivelResponsabilidad;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Nivel de responsabilidad: "+nivelResponsabilidad);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("La jubilación del jefe");
        double jubilacion=0.0;
        switch (nivelResponsabilidad){
            case 'A':
                jubilacion=2000;break;
            case 'B':
                jubilacion=1500;break;
            case 'C':
                jubilacion=1250;break;
        }
    }

    @Override
    public int votar(int voto) {
        return voto/3;
    }
}
