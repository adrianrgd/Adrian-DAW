/*Diseña un programa que solicite al usuario el nombre de colores. Dejará de solicitar nuevos colores cuando se 
introduzca ‘negro’ (NO  sensible  a mayúsculas). 
Al finalizar imprime el número de colores total introducido, excluyendo el ‘negro’ Y el número de veces que se ha 
introducido ‘azul’ (sensible a mayúsculas)*/

import java.util.Scanner;

public class bucles13 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String colores = "";
        int contadorColores = 0;
        int contadorAzul = 0;

        while (true) {
            System.out.println("Introduce un color: ");
            colores = teclado.nextLine();
            if (colores.equalsIgnoreCase("negro")) {
                System.out.println("Programa Terminado!!");
                System.out.println("Numero de colores introducidos: " + contadorColores);
                System.out.println("Numero de veces que se introdujo el color Azul: " + contadorAzul);
                break;
            }
            contadorColores++;

            if (colores.equals("azul")) {
                contadorAzul++;
            }
        }

        teclado.close();
    }
}