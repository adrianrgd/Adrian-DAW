
import java.util.Scanner;

public class Funciones12 {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String texto = "";

        while (!texto.equalsIgnoreCase("salir")) {
            System.out.println("Introduce un texto: ");
            texto = teclado.nextLine();

            if (texto.equalsIgnoreCase("salir")) {
                System.out.println("Programa Finalizado!");
                break;
            }

            System.out.println("El texto tiene " + contarVocales(texto) + " vocales.");
        }
    }
    
    public static int contarVocales(String texto) {
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contador++;
            }
        }

        return contador;
    }
}