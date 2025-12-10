/*Modifica el ejercicio 2 para que, indicando dos números n y m, diga qué 
cantidad hay que sumarle a n para que sea múltiplo de m.*/

import java.util.Scanner;

public class EJ3 {
    public static void main(String[] args) {
        
        //Solicitamos dos numeros
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        int num = teclado.nextInt();

        System.out.println("Introduce el multiplo: ");
        int mul = teclado.nextInt();

        //Calculamos la cantidad que hay que sumar para que sea multiplo del numero introducido.
        int resultado = (num % mul == 0) ? 0 : (mul - (num % mul));
        System.out.println("Hay que sumarle " + resultado + " para que sea múltiplo de " + mul);
    }
}
