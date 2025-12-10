
import java.util.Scanner;

/*Escribe un programa que determine si un año, introducido por el usuario, es bisiesto o no.  
Imprime el mensaje “¿Es el año AAAA bisiesto? : true/false” donde AAAA es el año indicado por el usuario. 
Considera que un año es bisiesto si es múltiplo de 4 pero no de 100 , o bien, es múltiplo de 400.*/
public class Condicionales3 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un año: ");
        int año = teclado.nextInt();//Solicitamos un año al usuario

        if (año % 4 == 0) {
            System.out.println("El año " + año + " es bisiesto.");
        } else {
            System.out.println("El año " + año + " no es bisiesto.");
        }
        teclado.close();
    }
}
