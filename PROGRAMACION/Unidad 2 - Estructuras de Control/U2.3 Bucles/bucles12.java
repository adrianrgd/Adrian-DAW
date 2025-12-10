/*Diseña un programa que solicite números enteros que irá sumando (acumulando). Cuando detecte que se ha introducido
dos veces seguidas el mismo valor, imprimirá el mensaje “Valor repetido. El total de la suma es: XXXX”*/

import java.util.Scanner;

public class bucles12 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int num;
        int anterior = Integer.MIN_VALUE;
        int suma = 0;

        while (true) {
            System.out.println("Introduce un numero: ");
            num = teclado.nextInt();
            suma += num;
            if (num == anterior) {
            System.out.println("Valor Repetido! Suma de todos los numeros: " + suma);
            break;
            }
        
            anterior = num;
        }
        teclado.close();
    }
}
