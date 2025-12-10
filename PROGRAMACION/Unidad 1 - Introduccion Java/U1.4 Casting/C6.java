
import java.util.Scanner;

/*Escribe un programa que reciba un número decimal float y lo convierta a byte usando 
casting explícito. Muestra los valores originales y convertidos, destacando la posible 
pérdida de precisión. */

public class C6 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        float n = teclado.nextFloat();

        //convertimos decimal float a byte
        byte b = (byte) n;

        //Resultado
        System.out.println("Valores originales: " + (float)n);
        System.out.println("Valores convertidos: " + (byte)b);
        System.out.println("Puede haber perdida de precision o desbordamiento al convertir en byte.");
    }
}
