/*Diseña  un  programa  que  solicite  un  número  entero  ‘N’.  A  continuación, 
solicitará al usuario N números y finalizará imprimiendo la media de todos los 
valores.*/

import java.util.Scanner;

public class bucles10 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un número entero: ");
        int n = teclado.nextInt();

        if (n > 0) {
            double suma = 0;
            for (int i = 1; i <= n; i++) {
                System.out.println("Introduce el número " + i + ": ");
                int num = teclado.nextInt();
                suma += num;
            }
            double media = (double) suma / n;
            System.out.println("La media de los números introducidos es: " + media);
        } else {
            System.out.println("No se han introducido números.");
        }
    
        teclado.close();
    }
}
