import java.util.Scanner;

public class Funciones4 {
    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Introduce un numero: ");
            int num = teclado.nextInt();
            
            System.out.println("El numero es par: " + esPar(num));
        }
    }

    public static boolean esPar(int num) {
        boolean resultado;
        resultado = num % 2 == 0;
        return resultado;
    }
}
