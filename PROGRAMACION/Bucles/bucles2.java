
/*Diseña  un  programa  que  solicite  un  número  entre  0  y  10  y  a  continuación 
imprima la tabla de multiplicar de dicho número. Implementa la validación del 
dato de entrada.*/

import java.util.Scanner;

public class bucles2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero del 1 al 10: ");
        int n = teclado.nextInt();

        if (n < 0 || n > 10) {
            System.out.println("Error!! Introduce un numero entre 0 y 10.");
        } else {
            System.out.println("Tabla de multiplicar del " + n);
        }
    
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n*i));
        }
        
        teclado.close();
    }
}
