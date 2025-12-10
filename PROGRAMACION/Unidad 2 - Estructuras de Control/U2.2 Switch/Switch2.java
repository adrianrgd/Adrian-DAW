
import java.util.Scanner;

/*Escribe un programa que reciba una calificación (A, B, C, D, F) e imprima el literal correspondiente a esta tabla: 
A Sobresaliente 
B Notable 
C Bien 
D Suficiente 
F Suspendido 
Utiliza la estructura switch ‘nueva’*/
public class Switch2 {
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Introduce la calificacion: ");
            String Nota = teclado.nextLine();
            
            switch (Nota) {
                case "A" -> System.out.println("Sobresaliente");
                case "B" -> System.out.println("Notable");
                case "C" -> System.out.println("Bien");
                case "D" -> System.out.println("Suficiente");
                case "F" -> System.out.println("Suspendido");
            }
        }
    }
}
