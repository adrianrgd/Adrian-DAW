/*Diseña un programa que solicite 10 números y devuelva el resultado de multiplicar todos ellos*/

import java.util.Scanner;

public class bucles8 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int num;
        int contador = 1;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce el número " + i + ": ");
            num = teclado.nextInt();
            contador *= num;
        }
        
        System.out.println("El resultado de multiplicar los números introducidos es: " + contador);
    
        teclado.close();
    }
}
