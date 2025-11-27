import java.util.Scanner;

public class Array6 {
    public static void main(String[] args) {
        int longitud = 4;
        double guardarNumeros[] = new double[longitud];

        for (int i = 0; i < longitud; i++) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce el numero " + (i + 1) + ": ");
            double num = teclado.nextDouble();
            guardarNumeros[i] = num;
        }

        getArrayNumMayor(guardarNumeros);
    }

    public static void getArrayNumMayor(double[] guardarNumeros) {
        double numMayor = guardarNumeros[0];
        for (int i = 1; i < guardarNumeros.length; i++) {
            if (guardarNumeros[i] > numMayor) {
                numMayor = guardarNumeros[i];
            }
        }
        System.out.println("\nEl número mayor es: " + numMayor);
    }
}
