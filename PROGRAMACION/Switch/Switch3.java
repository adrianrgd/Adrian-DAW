
import java.util.Scanner;

/*Escribe un programa que reciba un número entre 1 y 12 e imprima el nombre del mes  correspondiente.  
Si  el  número  no  está  en  el  rango,  muestra  un  mensaje  de error.*/
public class Switch3 {
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Ingresa un numero del 1 al 12: ");
            int num = teclado.nextInt();
            
            switch (num) {
                case 1 -> System.out.println("Es enero!");
                case 2 -> System.out.println("Es febrero!");
                case 3 -> System.out.println("Es marzo!");
                case 4 -> System.out.println("Es abril!");
                case 5 -> System.out.println("Es mayo!");
                case 6 -> System.out.println("Es junio!");
                case 7 -> System.out.println("Es julio");
                case 8 -> System.out.println("Es agosto!");
                case 9 -> System.out.println("Es septiembre!");
                case 10 -> System.out.println("Es octubre!");
                case 11 -> System.out.println("Es noviembre!");
                case 12 -> System.out.println("Es diciembre!");
                default -> System.out.println("Numero Invalido!! Elije uno entre 1 y 12.");
            }
        }
    }
}
