import java.util.Scanner;

public class Array5 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("¿¿Como de grande sera el array??");
        int longitud = teclado.nextInt();

        double guardarNumeros[] = new double[longitud];

        for (int i = 0; i < longitud; i++) {
            System.out.println("Introduce el numero " + (i + 1) + ": ");
            double num = teclado.nextDouble();
            guardarNumeros[i] = num;
        }

        System.out.println("\n=== Números guardados en el Array ===");
        for (int i = guardarNumeros.length - 1; i >= 0; i--) {
            System.out.println("Posición [" + i + "]: " + guardarNumeros[i]);
        }
    }
}
