
import java.util.Scanner;

public class Funciones15 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String palabra = "";

        System.out.println("Introduce una palabra: ");
        palabra = teclado.nextLine();

        System.out.println("La palabra invertida es: " + invertirPalabra(palabra));  
        teclado.close();    
    }
    
    public static String invertirPalabra(String palabra) {
        String palabraInvertida = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            palabraInvertida += palabra.charAt(i);
        }
        return palabraInvertida;
    }
}
