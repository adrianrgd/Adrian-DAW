import java.util.Scanner;

public class Funciones20 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un texto: ");
        String texto = teclado.nextLine();
        teclado.close();

        String textoLimpio = prepararCadena(texto);
        String textoInvertido = invertirCadena(textoLimpio);
        
        if (esPalindromo(textoLimpio, textoInvertido)) {
            System.out.println("'" + texto + "' ES un palíndromo");
        } else {
            System.out.println("'" + texto + "' NO es un palíndromo");
        }
    }

    public static String prepararCadena(String texto) {
        String textoLimpio = "";
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                textoLimpio += c;
            }
        }
        return textoLimpio;
    }

    public static String invertirCadena(String textoLimpio) {
        String textoInvertido = "";
        for (int i = textoLimpio.length() - 1; i >= 0; i--) {
            textoInvertido += textoLimpio.charAt(i);
        }
        return textoInvertido;
    }

    public static boolean esPalindromo(String textoLimpio, String textoInvertido) {
        return textoLimpio.equals(textoInvertido);
    }
}
