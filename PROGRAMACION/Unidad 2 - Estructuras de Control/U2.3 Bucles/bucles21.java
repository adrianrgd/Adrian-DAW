/*Bucles II -> Codifica el juego «el número secreto», que consiste en acertar un número entre 1 y 100 (generado  aleatoriamente).
El  usuario  va  introduciendo  números por teclado y el programa responde «mayor» o «menor», según sea mayor o menor 
con respecto al número secreto. El proceso termina cuando el usuario acierta o cuando se rinde (introduciendo un −1). */

import java.util.Scanner;

public class bucles21 {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println(ANSI_GREEN + "Bienvenido al juego: El Numero Secreto!!" + ANSI_RESET);
        int num = 0;
        int numsecreto = (int)(Math.random() * 101);
        final int RENDIRSE = -1;

        while (num != numsecreto) {
            System.out.println("Introduce un numero entre 1 y 100: ");
            num = teclado.nextInt();

            if (num == numsecreto) {
                System.out.println(ANSI_GREEN + "HAS GANADO, ERES UN SKIBIDI BRO!" + ANSI_RESET);
                break;
            } else if (num == RENDIRSE) {
                System.out.println(ANSI_RED + "TE RENDISTE! :c \nLa proxima vez seguro aciertas!!" + ANSI_RESET);
                break;
         
            }
            
            if (num > 100 || num < 0) {
                System.out.println(ANSI_RED + "Numero Invalido!!" + ANSI_RESET);
            } else if (num > numsecreto) {
                System.out.println("El numero secreto es más pequeño!");
            } else if (num < numsecreto) {
                System.out.println("EL numero secreto es más grande!");
            }
        }
        teclado.close();
    }
}
