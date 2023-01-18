public class Multiplicar {

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.printf("Tabla del %d%n",i);
            for (int j = 1; j < 11; j++) {
                System.out.printf("%d * %d = %d%n",i,j,i*j);
            }
        }

    }

}
