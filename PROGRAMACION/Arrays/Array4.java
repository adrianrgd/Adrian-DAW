
import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        int longitud = 5;
        double guardarNumeros[] = new double[longitud];

        for (int i = 0; i < longitud; i++) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce el numero " + (i + 1) + ": ");
            double num = teclado.nextDouble();
            guardarNumeros[i] = num;
        }

        System.out.println("\n=== Números guardados en el Array ===");
        for (int i = 0; i < guardarNumeros.length; i++) {
            System.out.println("Posición [" + i + "]: " + guardarNumeros[i]);
        }
    }
}
