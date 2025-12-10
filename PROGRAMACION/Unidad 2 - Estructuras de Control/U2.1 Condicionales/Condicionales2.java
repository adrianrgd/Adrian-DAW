
import java.util.Scanner;

/*Escribe un programa que determine si los asistentes a un evento musical tienen acceso preferente. Las condiciones para este tipo de acceso son: 
• Si la edad del participante es < 16 o > 65, se concede acceso preferente.
• Si la edad está comprendida entre 16 y 65 , no se concede acceso preferente salvo que se trate de un acompañante de 
alguien que sí tiene derecho a acceso preferente.*/
public class Condicionales2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        int edad = teclado.nextInt();//Edad del asistente

        System.out.println("¿Tienes acompañante con acceso preferente? (True/False): ");
        boolean acompañante = teclado.nextBoolean();

        if (edad < 16 || edad > 65) {
            System.out.println("Tienes acceso preferente al evento!");
        } else if ((edad >=16 && edad <=65) && acompañante) {
            System.out.println("Tienes acceso por ser acompañante de alguien preferente!");
        } else {
            System.out.println("No tienes acceso preferente!"); 
        }
        teclado.close();
    }
}
