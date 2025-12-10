
import java.util.Scanner;

/*Escribe un programa que solicite al usuario un número entero e imprima como salida si 
es positivo, negativo o cero. */
public class OT1 {
    public static void main(String[] args) {
        
        /*Declarar variables */
        int numero;

        /*Pedir un numero al usuario */
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        numero = teclado.nextInt();

        //Operador Terciario
        String resultado = (numero > 0) ? "El numero es positivo." : (numero < 0) ? "El numero es negativo." : "El numero es cero.";

        System.out.println(resultado);
    }
}
