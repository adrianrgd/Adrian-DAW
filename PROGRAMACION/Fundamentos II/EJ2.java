import java.util.Scanner;

/*Escribe un programa que tome como entrada un número entero e indique 
qué cantidad hay que sumarle para que el resultado sea múltiplo de 7.*/
public class EJ2 {
    public static void main(String[] args) {
        
        //Solicitamos un numero entero
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        int num = teclado.nextInt();

        //Calculamos la cantidad que hay que sumar para que sea multiplo de 7.
        int resultado = (num % 7 == 0) ? 0 : (7 - (num % 7));
        System.out.println("Hay que sumarle " + resultado + " para que sea múltiplo de 7.");
    }
}
