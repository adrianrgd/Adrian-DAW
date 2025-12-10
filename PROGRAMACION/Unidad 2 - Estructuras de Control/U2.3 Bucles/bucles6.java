import java.util.Scanner;

/* Diseña un programa que solicite un número entero y que a continuación imprima todos 
los números impares desde el 1 hasta el proporcionado por teclado. */
public class bucles6 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = teclado.nextInt();

        System.out.println("Los números impares de 1 a " + num + " son:");

        if (num >= 1) {
            // Caso positivo
            for (int i = 1; i <= num; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        } else {
            // Caso negativo
            for (int i = 1; i >= num; i--) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        }

        teclado.close();
    }
}
