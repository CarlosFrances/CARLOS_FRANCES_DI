package model;

import java.util.ArrayList;

public class CentroSalud {

    private ArrayList<Medico> listaMedicos;
    private ArrayList<Paciente> listaPacientes;

    public CentroSalud(){
        listaMedicos=new ArrayList<>();
        listaPacientes=new ArrayList<>();
    }

    private void contratarMedicos(){
        listaMedicos.add(new Medico("a","b","c",001,"d"));
        listaMedicos.add(new Medico("b","c","d",002,"e"));
        listaMedicos.add(new Medico("c","d","e",003,"f"));
        listaMedicos.add(new Medico("d","e","f",004,"g"));
        listaMedicos.add(new Medico("e","f","g",005,"h"));

    }


}
