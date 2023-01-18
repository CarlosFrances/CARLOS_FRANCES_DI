package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    Scanner scan=new Scanner(System.in);

    private ArrayList<Cita> citas1=new ArrayList<>();


    Medico medico1=new Medico("Nick","Rivera",
            "traumatologia","001",001,citas1);
    private ArrayList<Cita> citas2=new ArrayList<>();

    Medico medico2=new Medico("Hannibal","Lecter",
            "digestivo","002",002,citas2);
    private ArrayList<Cita> citas3=new ArrayList<>();

    Medico medico3=new Medico("Sam","ROwens",
            "psiquiatria","003",003,citas3);
    private ArrayList<Cita> citas4=new ArrayList<>();

    Medico medico4=new Medico("Martin","Brenner",
            "general","004",004,citas4);
    private ArrayList<Cita> citas5=new ArrayList<>();

    Medico medico5=new Medico("Stephen","Strange",
            "cirugia","005",005,citas5);


    //Agrega todos los medicos al arraylist de medicos
    public void addMedicos(){
        medicos.add(medico1);
        medicos.add(medico2);
        medicos.add(medico3);
        medicos.add(medico4);
        medicos.add(medico5);
    }

    public void listarCitasPaciente(){
        System.out.println("---Listar Citas Paciente---");
        System.out.println("Introduzca su NSS: ");
        int NSS=scan.nextInt();
        for (Paciente paciente:pacientes){
            if(paciente.getNSS()==NSS){
                System.out.println(paciente.getCitas().toString());
            }
        }
    }

    public void listarMedicos(){
        System.out.println("---Listar Medicos---");
        System.out.println("Introduzca especialidad: ");
        String especialidad=scan.next();
        for(Medico medico:medicos){
            if(medico.getEspecialidad().equalsIgnoreCase(especialidad)){
                System.out.println(medico.toString());
            }
        }
    }

    private ArrayList<Medico> medicos=new ArrayList<>();
    public void pedirCita(){
        System.out.println("---Pedir cita---");
        System.out.println("Introduce NSS: ");
        int NSS=scan.nextInt();

        boolean found=false;
        for (Paciente paciente:pacientes){
            if(paciente.getNSS()==NSS){
                found=true;
            }
        }
        if(found){
            System.out.println("Introduce la especialidad: ");
            String especialidad=scan.next();
            System.out.println("Introduce el numero de colegiado: ");
            int numeroColegiado=scan.nextInt();
            System.out.println("Introduce dia de la cita: ");
            int dia=scan.nextInt();
            System.out.println("Introduce mes de la cita: ");
            int mes=scan.nextInt();
            System.out.println("Introduce comentario para la cita: ");
            String comentario=scan.next();

            boolean citable=true;
            for (Medico medico:medicos){
                if(medico.getNumeroColegiado()==numeroColegiado){
                    for(Cita cita:medico.getCitas()){
                        if(cita.getDia()==dia || cita.getMes()==mes){
                            citable=false;
                            System.out.println("No se puede pedir cita, médico ocupado");
                        }
                    }if(citable){
                        System.out.println("Cita solicitada con éxito");
                        ArrayList<Cita> c=medico.getCitas();
                        Cita cit=new Cita(dia,mes);
                        c.add(cit);
                        medico.setCitas(c);
                        for(Paciente paciente:pacientes){
                            if(paciente.getNSS()==NSS){
                                paciente.addCita(cit);
                            }
                        }
                    }
                }
            }
        }
    }
    private ArrayList<Paciente>pacientes=new ArrayList<>();
    public void registrarPaciente(){
        System.out.println("---Registrar paciente---");
        System.out.println("Introduzca nombre: ");
        String nombre=scan.next();
        System.out.println("Introduzca apellido: ");
        String apellido=scan.next();
        System.out.println("Introduzca DNI: ");
        String DNI=scan.next();
        System.out.println("Introduzca NSS: ");
        int NSS=scan.nextInt();
        boolean found=false;
        for (Paciente paciente:pacientes){
            if(paciente.getNSS()==NSS){
                found=true;
                System.out.println("El paciente ya existe");
            }
        }
        if(!found) {
            Paciente paciente = new Paciente(nombre, apellido, NSS, DNI);
            pacientes.add(paciente);
            System.out.println("Paciente registrado correctamente");
        }
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
