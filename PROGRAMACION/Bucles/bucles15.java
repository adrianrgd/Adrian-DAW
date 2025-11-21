/*Bucles II -> Diseña un programa que muestre, para cada número introducido por teclado, si es par, si es positivo y su cuadrado. 
El proceso se repetirá hasta que el número introducido sea 0. */

import java.util.Scanner;

public class bucles15 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa un numero: ");
        int num = teclado.nextInt();

        while (num != 0) {
            if (num % 2 == 0 && num > 0) {
                System.out.println("El numero es Par y Positivo!");
            } else if (num % 2 == 0 && num < 0) {
                System.out.println("El numero es Par y Negativo!");
            } else if (num % 2 != 0 && num > 0) {
                System.out.println("El numero es Impar y Positivo!");
            } else if (num % 2 != 0 && num < 0) {
                System.out.println("El numero es Impar y Negativo!");
            }

            int cuadrado = (num * num);
            System.out.println("Su cuadrado es: " + cuadrado);

            System.out.println("Ingresa un numero: ");
            num = teclado.nextInt();
        }
        
        System.out.println("El numero introducido es 0! Programa Finalizado!");
        teclado.close();
    }  
}
