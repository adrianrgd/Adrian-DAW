
import java.util.Scanner;

/*Escribe  un  programa  que  solicite  un  número  del  1  al  7  e  imprima  el  día  de  la 
semana correspondiente (1 para lunes, 2 para martes, etc.). Si el número no está 
en el rango, muestra un mensaje de error.*/
public class Switch1 {
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Introduce un numero del 1 al 7: ");
            int num = teclado.nextInt();
            
            switch (num) {
                case 1 -> System.out.println("Es Lunes");
                case 2 -> System.out.println("Es Martes");
                case 3 -> System.out.println("Es Miercoles");
                case 4 -> System.out.println("Es Jueves");
                case 5 -> System.out.println("Es Viernes");
                case 6 -> System.out.println("Es Sabado");
                case 7 -> System.out.println("Es Domingo");
                default -> System.out.println("Numero invalido, tiene que ser entre 1 y 7!");
            }
        }
    }
}
