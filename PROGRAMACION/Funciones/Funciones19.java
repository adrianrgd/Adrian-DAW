import java.util.Scanner;

public class Funciones19 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un texto: ");
        String texto = teclado.nextLine();
        teclado.close();

        analizarTexto(texto);
    }

    public static String limpiarTexto(String texto) {
        String textoLimpio = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c) || c == ' ') {
                textoLimpio += c;
            }
        }
        return textoLimpio;
    }

    public static int contarPalabras(String textoLimpio) {
        int contadorPalabras = 1;
        if (textoLimpio.isEmpty()) return 0;
        for (int i = 0; i < textoLimpio.length(); i++) {
            char palabras = textoLimpio.charAt(i);
            if (palabras == ' ') {
                contadorPalabras++;
            }
        }
        return contadorPalabras;
    }

    public static int contarVocales(String textoLimpio) {
        int contadorVocales = 0;
        for (int i = 0; i < textoLimpio.length(); i++) {
            char vocales = textoLimpio.charAt(i);
            switch (Character.toLowerCase(vocales)) {
                case 'a', 'e', 'i', 'o', 'u' -> contadorVocales++;
            }
        }
        return contadorVocales;
    }

    public static int contarNumeros(String textoLimpio) {
        int contadorNumeros = 0;
        for (int i = 0; i < textoLimpio.length(); i++) {
            char numeros = textoLimpio.charAt(i);
            if (Character.isDigit(numeros)) {
                contadorNumeros++;
            }
        }
        return contadorNumeros;
    }

    public static void analizarTexto(String texto) {
        String textoLimpio = limpiarTexto(texto);
        System.out.println("Texto Original: " + texto);
        System.out.println("Texto Limpio: " + textoLimpio);
        System.out.println("Número de Palabras: " + contarPalabras(textoLimpio));
        System.out.println("Número de Vocales: " + contarVocales(textoLimpio));
        System.out.println("Número de Dígitos: " + contarNumeros(textoLimpio));
    }
}
