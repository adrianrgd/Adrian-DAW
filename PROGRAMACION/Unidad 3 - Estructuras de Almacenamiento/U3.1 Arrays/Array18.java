import java.util.Arrays;
import java.util.Scanner;

public class Array18 {
    public static void main(String[] args) {
        
        int valor = 0;
        int array[] = new int[10];

        for (int i = 0; i < array.length; i++) {
            int aleatorios = (int) (Math.random() * 100);
            array[i] = aleatorios;
        }

        Arrays.sort(array);

        System.out.println("Array ordenado: " + Arrays.toString(array));
        insertarValor(array, valor);
    }

    public static void insertarValor(int array[], int valor) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nIntroduce un valor para eliminar: ");
        valor = teclado.nextInt();

        int contador = 0;
        for (int num : array) {
            if (num != valor) {
                contador++;
            }
        }

        int arrayValorEliminado[] = new int[contador];

        int inicio = 0;
        for (int num : array) {
            if (num != valor) {
                arrayValorEliminado[inicio] = num;
                inicio++;
            }
        }

        System.out.println("Array con nuevo valor: " + Arrays.toString(arrayValorEliminado));
    }
}