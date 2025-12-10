/*Bucles II -> Diseña  un  programa  que  solicite  cadenas  de  texto  al  usuario  hasta  que  la entrada sea el 
texto ‘salir’, no sensible a mayúsculas. Cuando el usuario termina De introducir las cadenas de texto el programa devuelve: 
a. Número de palabras que empiezan por A 
b. Número de palabras que empiezan por M 
c. Número de palabras que no empiezan por A ni por M.  */

import java.util.Scanner;

public class bucles19 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String texto = "";
        int contadorA = 0;
        int contadorM = 0;
        int contadorNoAM = 0;
        char primeraLetra;

        while (true) {
            System.out.println("Introduce una palabra: ");
            texto = teclado.nextLine();

            if (texto.equalsIgnoreCase("salir")) {
                System.out.println("FIN DEL PROGRAMA!");
                System.out.println("Numero de palabras que empiezan por A: " + contadorA);
                System.out.println("Numero de palabras que empiezan por M: " + contadorM);
                System.out.println("Numero de palabras que NO empiezan por A o M: " + contadorNoAM);
            } 
            
            primeraLetra = texto.charAt(0);

            if (primeraLetra == 'A' || primeraLetra == 'a') {
                contadorA++;
            } else if (primeraLetra == 'M' || primeraLetra == 'm') {
                contadorM++;
            } else {
                contadorNoAM++;
            }
        }
    }
}
