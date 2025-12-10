
import java.util.Scanner;

/*Escribe una aplicación que solicite por consola dos números reales que 
corresponden a la base y la altura de un triángulo. Deberá mostrarse su área, 
comprobando que los números introducidos por el usuario no son negativos ni 
igual a cero.*/
public class CondicionalesII1 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la base: ");
        int base = teclado.nextInt();

        System.out.println("Introduce la altura: ");
        int altura = teclado.nextInt();

        double resultado = ((base * altura) / 2);

        if (base <= 0 && altura >= 0 || base >= 0 && altura <= 0) {
            System.out.println("Error!");
        } else {
            System.out.println("El área es " + resultado);
        }
    }
}
