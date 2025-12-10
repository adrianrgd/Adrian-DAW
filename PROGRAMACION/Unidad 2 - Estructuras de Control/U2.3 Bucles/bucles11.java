/*Diseña  un  programa  que  solicite  palabras  en  minúscula  al  usuario  y  las 
imprima en mayúsculas, finalizará cuando el usuario teclee la palabra ‘fin’*/

import java.util.Scanner;

public class bucles11 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String palabra = "";

        while (palabra != "fin") {
            System.out.println("Introdue una palabra en minuscula ('fin' para terminar el programa): ");
            palabra = teclado.nextLine();
            System.out.println("Palabra en mayusculas: " + palabra.toUpperCase());
            if (palabra == "fin") {
                System.out.println("Programa terminado.");
            }
        }
        
        teclado.close();
    }
}
