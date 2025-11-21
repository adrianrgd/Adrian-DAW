/*Bucles II -> Desarrolla  un  programa  que  solicite  un  número  entero  y  dibuje  un  triángulo 
rectángulo de n elementos asterisco (*) de lado. */

import java.util.Scanner;

public class bucles22 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int num = teclado.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        teclado.close();
    }
}

