
import java.util.Scanner;

public class Funciones7 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce las horas (1): ");
        int hora1 = teclado.nextInt();
        System.out.println("Introduce los minutos (1): ");
        int minuto1 = teclado.nextInt();
        System.out.println("Primera hora: " + hora1 + " h " + minuto1 + " min.");

        Scanner teclado2 = new Scanner(System.in);
        System.out.println("Introduce las horas (2): ");
        int hora2 = teclado.nextInt();
        System.out.println("Introduce los minutos (2): ");
        int minuto2 = teclado.nextInt();
        System.out.println("Primera hora: " + hora2 + " h " + minuto2 + " min.");

        System.out.println("La diferencia de minutos entre ambas horas es de " + diferenciaMin(hora1, minuto1, hora2, minuto2) + " minutos.");
    }    

    public static int diferenciaMin(int hora1, int minuto1, int hora2, int minuto2) {
        int resultado1;
        int resultado2;
        int diferencia;

        resultado1 = (hora1 * 60) + minuto1;
        resultado2 = (hora2 * 60) + minuto2;
        
        if (resultado1 < resultado2) {
            diferencia = (resultado2 - resultado1);
        } else {
            diferencia = (resultado1 - resultado2);
        }

        return diferencia;
    }
}
