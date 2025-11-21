
import java.util.Scanner;

public class Funciones13 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String texto = teclado.nextLine();

        System.out.println("Introduce un caracter a buscar: ");
        char buscarLetra = teclado.nextLine().charAt(0);

        System.out.println("El caracter '" + buscarLetra + "' " + (buscarChar(texto, buscarLetra) ? "se encuentra" : "no se encuentra") + " en el texto " + "'" + texto + "'.");
    }
    
    public static boolean buscarChar(String texto, char buscarLetra) {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == buscarLetra) {
                return true;
            }
        }
        return false;
    }
}
