package model;

public final class Autonomo extends Trabajador {

    private int cuotaSS, totalFactura;

    public Autonomo(String nombre, String apellido, String dni, int NSS, int cuotaSS, int totalFactura) {
        super(nombre, apellido, dni, NSS);
        this.cuotaSS = cuotaSS;
        this.totalFactura = totalFactura;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Cuota SS: " + cuotaSS);
        System.out.println("Total factura: " + totalFactura);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calculando jubilación del autonomo");
        System.out.println("Tu jubilación es " + cuotaSS / 2);
    }
}
