import java.util.Scanner;

public class Array6 {
    public static void main(String[] args) {
        int longitud = 4;
        int guardarNumeros[] = new int[longitud];
        System.out.println("=== JUEGO DEL MAYOR ===");

        for (int i = 0; i < longitud; i++) {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Introduce el numero " + (i + 1) + ": ");
            int num = teclado.nextInt();
            guardarNumeros[i] = num;
            teclado.close();
            
        }

        getArrayNumMayor(guardarNumeros);
    }

    public static void getArrayNumMayor(int[] guardarNumeros) {
        int numMayor = guardarNumeros[0];
        for (int i = 1; i < guardarNumeros.length; i++) {
            if (guardarNumeros[i] > numMayor) {
                numMayor = guardarNumeros[i];
            }
        }
        System.out.println("\nEl número mayor es " + numMayor);
    }
}
