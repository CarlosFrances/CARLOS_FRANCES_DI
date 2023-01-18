import java.util.Calendar;
import java.util.Scanner;

public class MainRepaso {

    //1-ATRIBUTOS Y PROPIEDADES

    //2-CONSTRUCTORES

    //3-MÉTODOS

    //4-GETTER Y SETTER

    //5-toString

    /**
     * Comentario de documentación*/



    public static void main(String[] args) {
        String nombre; //null
        int edad; // vale 0
        boolean confirmar; //vale false

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce nombre");
        nombre = scanner.next();
        System.out.println("Introduce edad");
        edad = scanner.nextInt();
        System.out.printf("Bienvenido %s tienes %d\n",nombre,edad);

        // OPERADORES

        // aritmeticos
        // + - * / % -
        // 4%2 = 0 --> par/impar, posiciones
        // unarios
        // ++ --
        // asignación
        // =
        // asignación y aritméticos
        // += -= *= /= %=
        // relacionales
        // > >= < <= == !=
        // lógicos
        // AND (&&) --> V cuando todos son True
        // OR (||) --> V cuando una de las condiciones es true
        // ternario
        // condición ? cuando_true : cuando_false
        // condicion & cuando_true

        // ESTRUCTURAS DE CONTROL
        // if
        edad=20;
        if (edad>=18) {
            System.out.println("Eres mayor de edad");
        }else if (edad>=14 && edad<18){
            System.out.println("Eres casi mayor de edad");
        }else{
            System.out.println("Eres menor de edad");
        }

        // switch
        // String int char
        edad=1;
        switch(edad){
            case 1: break;
            case 2: break;
            case 3: break;
            default:

        }

        // while --> minimo 0 - n

        edad=10;
        while(edad<18){
            System.out.println("Todavía no eres mayor de edad");
            //modificar la condición
            edad++;
        }


        // do while --> minimo 1 - n
        do{
            System.out.println("Todavía no eres mayor de edad");
            edad++;

        }while(edad<18);
        //for
        // 0 1 2 3 4 5 6 7 8 9
        int[] numeros ={1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < 10; i++) {
            // ejecucion
            System.out.println(numeros[i]);
        }

        // for each - recorridos completos
        /*int[] numeros ={1,2,3,4,5,6,7,8,9,10};
        for (int item:numeros){
            System.out.println(item);
            if(item!=9)break;
        }*/





    }

}
