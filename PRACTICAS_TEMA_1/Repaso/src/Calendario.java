import java.util.Calendar;
import java.util.Scanner;

public class Calendario {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String respuesta;
        System.out.println("Por favor, introduce tu nombre: ");
        String nombre=scanner.next();
        do{
            Calendar calendar= Calendar.getInstance();
            int dia=calendar.get(Calendar.DAY_OF_MONTH);
            int mes=calendar.get(Calendar.MONTH);
            int hora=calendar.get(Calendar.HOUR_OF_DAY);
            int minuto=calendar.get(Calendar.MINUTE)-25;
            int anno=calendar.get(Calendar.YEAR);
            String[] nombremes={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
                    "Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
            String tiempo;
            if(hora<12)tiempo="Buenos días" ;
            else if(hora<21)tiempo="Buenas tardes";
            else tiempo="Buenas noches";
            System.out.printf("%s %s, Son las %d:%d del %d de %s de %d\n" +
                            "",
                    tiempo,nombre,hora,minuto,dia,nombremes[mes],anno);

            System.out.println("¿Quieres volver a comprobar la hora?");
            respuesta=scanner.next();

        }while(respuesta.equals("y")||respuesta.equals("Y"));
        System.out.println("Fin del programa.");
    }
}
