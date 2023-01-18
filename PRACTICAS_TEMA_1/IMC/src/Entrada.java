import model.Persona;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("Escribe tu nombre: ");
        String nombre=scanner.next();
        System.out.println("Escribe tu edad: ");
        int edad=scanner.nextInt();
        System.out.println("Escribe tu sexo: ");
        String sexo=scanner.next();
        System.out.println("Escribe tu peso: ");
        double peso=scanner.nextDouble();
        System.out.println("Escribe tu altura: ");
        double altura=scanner.nextDouble();

        Persona persona1=new Persona();
        persona1.setNombre(nombre);
        persona1.setEdad(edad);
        persona1.setSexo(sexo);
        persona1.setPeso(peso);
        persona1.setAltura(altura);

        Persona persona2=new Persona(nombre,edad,sexo);

        Persona persona3=new Persona();
        persona1.setNombre("Carlos");
        persona1.setEdad(23);
        persona1.setSexo("Hombre");
        persona1.setPeso(70.0);
        persona1.setAltura(1.8);
        persona1.setDNI("48760807W");

        persona1.mensajeImc(persona1.calcularIMC());
        persona2.mensajeImc(persona2.calcularIMC());
        persona3.mensajeImc(persona3.calcularIMC());

        System.out.println(persona1.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());
    }

}
