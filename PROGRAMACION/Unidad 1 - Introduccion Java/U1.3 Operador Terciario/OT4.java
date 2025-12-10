import java.util.Scanner;
/*Escribe un programa que determine si un número es par o divisible por 5. */

public class OT4{
    public static void main(String[] args) {

        /*Solicitar numero al usuario */
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numero = teclado.nextInt();
        String resultado;

        /*Operador Terciario
        Determinar si el numero es par o divisible por 5.*/
        resultado = (numero % 2 == 0) ? "Es Par." : (numero % 5 == 0) ? "Es divisible por 5." : (numero % 2 == 0 && numero % 5 == 0) ? "Es Par y divisible por 5." : "El numero no es Par ni divisible por 5.";
        System.out.println(resultado);
    }
}