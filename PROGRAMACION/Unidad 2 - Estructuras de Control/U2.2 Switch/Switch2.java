
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
            
            String resultado = switch (Nota) {
                case "A" -> "Sobresaliente";
                case "B" -> "Notable";
                case "C" -> "Bien";
                case "D" -> "Suficiente";
                case "F" -> "Suspendido";
                default -> "Calificacion invalida";
            };
        }
    }
}
