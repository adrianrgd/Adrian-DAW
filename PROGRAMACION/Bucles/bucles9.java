/*Diseña un programa que imprima los múltiplos de 3 comprendidos entre 5 y 50*/

import java.util.Scanner;

public class bucles9 {
    
    Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        
        int a = 5;
        int b = 50;

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0)  {
                System.out.println(i);
            }
        }
        System.out.println("Los múltiplos de 3 entre " + a + " y " + b + " son:");
    }
}
