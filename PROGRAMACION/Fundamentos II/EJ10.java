
import java.util.Scanner;

/*Solicita al usuario un número real y calcula su raíz cuadrada. Implementa el 
programa utilizando el nombre cualificado de las clases, en lugar de utilizar 
ninguna importación.*/
public class EJ10 {
    public static void main(String[] args) {
        
        //Solicitar numero real
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero real: ");
        int num = teclado.nextInt();

        //calcular la raiz cuadrada
        double raiz = Math.sqrt(num); 
        System.out.println(raiz);
    }
}
