/*Diseña un programa que solicite dos números al usuario y calcule 
la suma de todos los números que se encuentran entre ambos. 
Por ejemplo, para los datos de entrada 4 y 8 calcula = 4+5+6+7+8*/

import java.util.Scanner;

public class bucles4 {
    public static void main(String[] args) {
         
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int a = teclado.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int b = teclado.nextInt();
        
        int suma = 0;

        for (int i = a; i <= b; i++) {
            suma += i;
        }
        
        System.out.println("La suma de los numeros entre " + a + " y " + b + " es: " + suma);
        
        teclado.close();
    }
}
