import java.util.Scanner;

/*Escribe un programa que compruebe si un número es múltiplo de 3, de 7, de ambos o 
de ninguno. */
public class OT7 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numero = teclado.nextInt();
        String resultado;

        resultado = (numero % 3 == 0) ? "Es multiplo de 3." 
        : (numero % 7 == 0) ? "Es multiplo de 7." 
        : (numero % 3 == 0 && numero % 7 == 0) ? "Es multiplo de ambos." : "No es multiplo de ninguno.";

        System.out.println(resultado);
    }
}
