
import java.util.Scanner;

public class Funciones17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int a = teclado.nextInt();
        System.out.println("Introduce otro numero: ");
        int b = teclado.nextInt();

        if (numAmigos(a, b)) {
            System.out.println(a + " y " + b + " son numeros amigos.");
        } else {
            System.out.println(a + " y " + b + " no son numeros amigos.");
        }
    }

    public static int DivisoresSuma(int n) {
        int suma = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                suma += i;
            }
        }
        return suma;
    }

    public static boolean numAmigos(int a, int b) {
        return DivisoresSuma(a) == b && DivisoresSuma(b) == a;
    }
}
