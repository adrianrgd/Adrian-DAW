
import java.util.Scanner;

/* Escribe un programa que tome un número de tipo short y lo convierta explícitamente a 
int. Luego, realiza la conversión inversa (de int a short) y muestra ambos valores.*/

public class C10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero short: ");
        short x = teclado.nextShort();

        //conversion short a int
        int a = (int)x;

        //conversion inversa
        short b = (short)a;

        //resultado
        System.out.println("Conversion Short a Int: " + (int)x + "\n");
        System.out.println("Conversion Inversa. " + (short)b);
    }
}
