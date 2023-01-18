package model;

public final class Asalariado extends Trabajador{

    private int numeroPagas;
    private int costeSS;
    private int sueldo;

    public Asalariado(String nombre, String apellido, String dni,
                      int NSS,int numeroPagas, int costeSS, int sueldo) {
        super(nombre, apellido, dni, NSS);
        this.numeroPagas=numeroPagas;
        this.costeSS=costeSS;
        this.sueldo=sueldo;
    }

    public void mostrarSueldoNeto(int retencion){
        double retencionReal = this.sueldo * retencion/100;
        double saldoAnualNeto = this.sueldo-retencionReal;
        double saldoMensualNeto = saldoAnualNeto/this.numeroPagas;
        System.out.println("Anual bruto: "+sueldo);
        System.out.println("Anual neto: "+saldoAnualNeto);
        System.out.println("Mensual neto: "+saldoMensualNeto);
    }

    public int getNumeroPagas() {
        return numeroPagas;
    }

    public void setNumeroPagas(int numeroPagas) {
        this.numeroPagas = numeroPagas;
    }

    public int getCosteSS() {
        return costeSS;
    }

    public void setCosteSS(int costeSS) {
        this.costeSS = costeSS;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Sueldo: "+sueldo);
        System.out.println("Número de pagas: "+numeroPagas);
        System.out.println("Coste SS: "+costeSS);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calcular la jubilación del asalariado");
        double calculo=(sueldo*numeroPagas)/50 * (int)(Math.random()*3+1);
        System.out.println("La jubilación que se le queda es: "+calculo);
    }
}
