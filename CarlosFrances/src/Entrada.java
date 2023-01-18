import model.*;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

        Hospital hospital=new Hospital();
        Scanner scan=new Scanner(System.in);

        int opcion;
        do{
            System.out.println("Elija opcion: (1,2,3,4)");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Pedir cita");
            System.out.println("3. Listar médicos");
            System.out.println("4. Listar citas paciente");
            System.out.println("5. Salir (cualquier otro numero)");

            opcion=scan.nextInt();

            switch (opcion){
                case 1:hospital.registrarPaciente();break;
                case 2:hospital.pedirCita();break;
                case 3:hospital.listarMedicos();break;
                case 4:hospital.listarCitasPaciente();
                case 5:break;
            }
        }while(opcion>0 && opcion<5);

    }
}
