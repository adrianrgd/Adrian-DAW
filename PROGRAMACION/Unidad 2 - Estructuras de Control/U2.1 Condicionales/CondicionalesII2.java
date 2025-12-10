
import java.util.Scanner;

/*Realiza el «juego de la suma» , que consiste en que aparezcan dos números enteros 
aleatorios (comprendidos entre 1 y 99) que el usuario tiene que sumar. 
La aplicación debe indicar si el resultado de la operación es correcto o incorrecto. */
public class CondicionalesII2 {
    public static void main(String[] args) {
        
        //Operacion para los 2 numeros aleatorios
        int num1 = (int) (Math.random() * 101);
        int num2 = (int) (Math.random() * 101);

        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cual es el resultado de esta suma? " + num1 + " + " + num2 + " : ");
        int num3 = teclado.nextInt();
            
        if (num1 + num2 == num3) {
            System.out.println("Es correcto");
        } else {
            System.out.println("No es correcto!");
        }
    }
}
