
import java.util.Arrays;
import java.util.Scanner;

public class Array15 {
    public static void main(String[] args) {
        int longitud = 0;
        int num = 0;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        longitud = teclado.nextInt();

        int array[] = new int[longitud];
        int arrayPares[] = new int[longitud];
        int arrayImpares[] = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            System.out.print("Introduce numeros en el array " + (i + 1) + ": ");
            num = teclado.nextInt();
            array[i] = num;

            if (num % 2 == 0) {
                arrayPares[i] = num;
            } else {
                arrayImpares[i] = num;
            }
        }

        Arrays.sort(array);
        Arrays.sort(arrayPares);
        Arrays.sort(arrayImpares);

        System.out.println("\n====== RESULTADOS ======");
        System.out.println("Tabla original: " + Arrays.toString(array));
        System.out.println("Tabla de Pares: " + Arrays.toString(arrayPares));
        System.out.println("Tabla de Impares: " + Arrays.toString(arrayImpares));
    }
}
