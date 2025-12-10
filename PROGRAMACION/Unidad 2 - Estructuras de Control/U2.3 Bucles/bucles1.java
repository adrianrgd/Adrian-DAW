/*Implementa  la  aplicación  Eco,  que  pide  al  usuario  un  número  y  muestra  en 
pantalla la salida: 
Eco... 
Eco... 
Eco... 
Se muestra «Eco...» tantas veces como indique el número introducido. La salida 
anterior sería para el número 3.*/

import java.util.Scanner;

public class bucles1 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Eco");
        }

        teclado.close();
    }
}
