/*Escribe un programa que solicite la nota de las diferentes asignaturas del ciclo 
(BBDD,  PROG,  F.BBDD,  ENT,  ITPE,  LM,  SSII)  y  con  una  función  con  2  parámetros 
calcule la media del curso y la devuelva con un valor double.  
El programa finaliza imprimiendo el resultado en pantalla*/
import java.util.Scanner;

public class Funciones1 {
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            double contador = 0;
            
            for (int i = 1; i <= 7; i++) {
                System.out.println("Introduce la nota: ");
                contador += teclado.nextDouble();
            }
            
            System.out.println("La media es " + media(contador, 7));
        }
    }
    
    public static double media(double suma, int numNotas) {

        double salida;

        if (numNotas > 0) {
            salida=suma/numNotas;
        } 
        else {
            salida = -1;
        }
        
        return salida;
    }
}
