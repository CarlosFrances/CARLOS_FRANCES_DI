import java.util.Arrays;
import java.util.Scanner;

public class Array {

    public Array() {
    }

    static Scanner scanner= new Scanner(System.in);

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private boolean esnulo(int[] a){
        return a == null;
    }

    /*COMPRUEBA SI EL ARRAY ES NULO, LO RELLENA Y EN CASO DE NO SERLO,
     PIDE CONFIRMACIÓN PARA RELLENARLO*/
    private void rellenar(int[] a){
        if(esnulo(a)){
            a=new int[50];
            for (int i = 0; i < a.length; i++) {
                a[i]=(int)(Math.random()*201);
            }
            this.setArray(a);
            System.out.println("El array ha sido rellenado\n");
        }else{
            System.out.println("El array ya está relleno. ¿Quieres sobreescribirlo? S/N\n");
            String respuesta=scanner.next();
            if(respuesta.equals("S")||respuesta.equals("s")){
                for (int i = 0; i < a.length; i++) {
                    a[i]=(int)(Math.random()*201);
                }
                this.setArray(a);
                System.out.println("El array se ha sobreescrito\n");
            }else System.out.println("El array no se ha modificado\n");
        }
    }

    /*COMPRUEBA SI EL ARRAY ES NULO, SI NO LO ES, MUESTRA CADA VALOR DEL ARRAY
     Y SU POSICIÓN POR PANTALLA*/
    private void listar(int[] a){
        if(esnulo(a)) System.out.println("No se puede listar el array porque es nulo\n");
        else for (int i = 0; i < a.length; i++) {
            System.out.printf("Elemento %d: %d%n",i+1,a[i]);
        }
    }

    //COMPRUEBA SI EL ARRAY ES NULO Y LO ORDENA DE MENOR A MAYOR
    private void ordenar(int[] a){
        if(esnulo(a)) System.out.println("No se puede ordenar el array porque es nulo\n");
        else {
            int[] b=a.clone();
            Arrays.sort(b);
            setArray(b);
            System.out.println("El array ha sido ordenado\n");
        }
    }

    //COMPRUEBA SI EL ARRAY ES NULO Y LO VACÍA
    private void vaciar(int[] a){
        if(esnulo(a)) System.out.println("No se puede vaciar el array porque es nulo\n");
        else{
            a=null;
            setArray(a);
            System.out.println("El array ha sido vaciado\n");
        }
    }

    private void buscar(int[] a){
        if(a==null){
            System.out.println("\nEl array está vacío, no se puede buscar");
        }else {
            System.out.println("\nElemento a buscar: ");
            int respuesta = scanner.nextInt();
            boolean found=false;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == respuesta) {
                    System.out.printf("\nnúmero %d encontrado en la posición: %d", respuesta, i+1);
                    found=true;
                    break;
                }
            }
            if(!found) System.out.printf("\nNo se ha encontrado el número %d en el array", respuesta);
        }
    }

    private void sustituir(int[] a){
        if(a==null){
            System.out.println("\nEl array está vacío, no se puede sustituir");
        }else {
            System.out.println("\nNúmero a sustituir: ");
            int sustituir=scanner.nextInt();
            System.out.println("\nNúmero por el que quiere sustituirlo: ");
            int sustituto=scanner.nextInt();
            for (int i = 0; i < a.length; i++) {
                if(a[i]==sustituir) a[i]=sustituto;
            }
            System.out.println("\nNúmeros sustituidos");
        }
    }

    private void maxMin(int[] a){
        if(a==null){
            System.out.println("\nEl array está vacío");
        }else {
            int min=201;
            int max=-1;
            for (int i = 0; i < a.length; i++) {
                if(a[i]<min) min=a[i];
                if(a[i]>max) max=a[i];
            }
            System.out.printf("\nMínimo: %d, máximo: %d",min,max);
        }
    }

    public static void main(String[] args) {
        int eleccion;
        Array a=new Array();
        do {
            System.out.println("    ELIJA OPCIÓN\n\n1- Rellenar array\n" +
                    "2- Listar array\n3- Ordenar array\n4- Vaciar array" +
                    "\n5- Buscar elemento\n6- Sustituir elemento" +
                    "\n7- Calcular máximo y mínimo\n8- Salir");
            eleccion=scanner.nextInt();
            switch (eleccion) {
                case 1 -> a.rellenar(a.getArray());
                case 2 -> a.listar(a.getArray());
                case 3 -> a.ordenar(a.getArray());
                case 4 -> a.vaciar(a.getArray());
                case 5 -> a.buscar(a.getArray());
                case 6 -> a.sustituir(a.getArray());
                case 7 -> a.maxMin(a.getArray());
            }

        }while(eleccion !=8);
    }
}
