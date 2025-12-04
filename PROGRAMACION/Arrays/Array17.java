
import java.util.Arrays;
import java.util.Scanner;

public class Array17 {
    public static void main(String[] args) {
        int valor = 0;
        int t[] = new int[10];

        for (int i = 0; i < t.length; i++) {
            int aleatorios = (int) (Math.random() * 100);
            t[i] = aleatorios;
        }

        Arrays.sort(t);

        System.out.println("Array ordenado: " + Arrays.toString(t));
        eliminaMayores(t, valor);

    }

    public static void eliminaMayores(int t[], int valor) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        valor = teclado.nextInt();

        int contador = 0;
        for (int num : t) {
            if (num <= valor) {
                contador++;
            }
        }

        int resultado[] = new int[contador];

        int inicio = 0;
        for (int num : t) {
            if (num <= valor) {
                resultado[inicio] = num;
                inicio++;
            }
        }

        System.out.println("Array ordenado: " + Arrays.toString(resultado));
    }
}
