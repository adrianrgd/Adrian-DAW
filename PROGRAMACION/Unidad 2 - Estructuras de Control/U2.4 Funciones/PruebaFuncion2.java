
import java.util.Scanner;

public class PruebaFuncion2 {
    public static void main(String[] args) {
        
        int a = 3;
        System.out.println("a: " + a);
        int num1 = suma3(a,7,5);
        int num2 = suma3(100,100,100);
        int num3 = suma3(1,2,3);

        System.out.println("Suma: " + num1);
        System.out.println("Suma (Valores a 100): " + num2);
        System.out.println("Suma (1 + 2 + 3)" + num3);
        System.out.println("Suma (a + 3): " + (a + 3));
        System.out.println("Suma de los resultados anteriores: " + suma3(num1, num2, num3));

        space();
        System.out.println("Valor Duplicado: " + duplica(a));
        System.err.println(a);

        space();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingrese un número entre 1 y 3: ");
            int numeroLetras = sc.nextInt();
            System.out.println(convertirLetras(numeroLetras));
            sc.close();
        }
    }

    // Función que suma 3 números enteros y devuelve el resultado
    public static int suma3(int a, int b, int c) {
        return a + b + c;
    }

    // Función que duplica el valor de un número entero y devuelve el resultado
    public static int duplica(int a) {
        a = 2 * a;
        return a;
    }
    
    public static String convertirLetras(int num) {
        String resultado;
        resultado = switch (num) {
            case 1 -> "Uno";
            case 2 -> "Dos";
            case 3 -> "Tres";
            default -> "Error!";
        };

        return resultado;
    }

    // Función que imprime una línea en blanco
    public static String space() {
        System.out.println(" ");
        return null;
    }
}
