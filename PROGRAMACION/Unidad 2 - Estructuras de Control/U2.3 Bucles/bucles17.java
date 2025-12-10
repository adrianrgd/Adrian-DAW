/*Bucles II -> Diseña un programa que calcule el factorial de un número solicitado por teclado. 
Por ejemplo, el factorial del número 7 es = 7x6x5x4x3x2x1*/

import java.util.Scanner;

public class bucles17 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int num = teclado.nextInt();
        int factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
            System.out.println("El factorial de " + num + " es: " + factorial);

        }
        teclado.close();
    }
}
