
import java.util.Scanner;

public class Funciones5 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int num = 0;

        while (esPar(num) == true) { 
            System.out.println("Introduce un numero: ");
            num = teclado.nextInt();
            System.out.println("El numero es par? " + esPar(num));
            if (esPar(num) != true) {
                System.out.println("Numero impar! Fin del Programa.");
                break;
            }
        }
        teclado.close();
    }
    
    public static boolean esPar(int num) {
        boolean resultado;
        resultado = num % 2 == 0;
        return resultado;
    }
}
