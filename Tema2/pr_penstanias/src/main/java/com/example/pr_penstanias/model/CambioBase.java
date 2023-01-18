package com.example.pr_penstanias.model;

public class CambioBase {

    private int numeroDecimal;
    private String numeroConv;
    private String numeroConv2;
    private int base;

    public CambioBase(int numeroDecimal, int base) {
        this.numeroDecimal = numeroDecimal;
        this.base = base;
    }

    public void cambioBase(){
        switch(base){
            case 2:{cambioBase2();break;}
            case 8:{cambioBase8();break;}
            case 16:{cambioBase16();break;}
        }
    }

    private void cambioBase16() {
        numeroConv="";
        while(numeroDecimal>base-1){
            int a=numeroDecimal%16;
            if(a>=10){
                switch (numeroDecimal%16){
                    case 10:{a='A';break;}
                    case 11:{a='B';break;}
                    case 12:{a='C';break;}
                    case 13:{a='D';break;}
                    case 14:{a='E';break;}
                    case 15:{a='F';break;}
                }
            }else{a=(char)numeroDecimal%16;}
            numeroConv+=a;
            numeroDecimal/=16;
        }
        char a='.';
        switch (numeroDecimal){
            case 0:{a='0';break;}
            case 1:{a='1';break;}
            case 2:{a='2';break;}
            case 3:{a='3';break;}
            case 4:{a='4';break;}
            case 5:{a='5';break;}
            case 6:{a='6';break;}
            case 7:{a='7';break;}
            case 8:{a='8';break;}
            case 9:{a='9';break;}
            case 10:{a='A';break;}
            case 11:{a='B';break;}
            case 12:{a='C';break;}
            case 13:{a='D';break;}
            case 14:{a='E';break;}
            case 15:{a='F';break;}
        }
        numeroConv+=a;
        devolverNumero();
    }

    private void cambioBase8() {
        numeroConv="";
        while(numeroDecimal>base-1){
            numeroConv+=numeroDecimal%8;
            numeroDecimal/=8;
        }
        numeroConv+=numeroDecimal;
        devolverNumero();
    }

    private void cambioBase2() {
        numeroConv="";
        while(numeroDecimal>base-1){
            numeroConv+=numeroDecimal%2;
            numeroDecimal/=2;
        }
        numeroConv+=numeroDecimal;
        devolverNumero();
    }

    private void devolverNumero(){
        numeroConv2="";
        for(int i = numeroConv.length()-1;i>=0;i--){
            char ch=numeroConv.charAt(i);
            numeroConv2+=ch;
        }
        numeroConv=numeroConv2;
    }
    public int getNumeroDecimal() {
        return numeroDecimal;
    }

    public void setNumeroDecimal(int numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }

    public String getNumeroConv() {
        return numeroConv;
    }

    public void setNumeroConv(String numeroConv) {
        this.numeroConv = numeroConv;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
