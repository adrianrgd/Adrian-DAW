import java.util.Scanner;

public class Funciones10 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la base: ");
        int base = teclado.nextInt();

        System.out.print("Introduce el exponente: ");
        int exponente = teclado.nextInt();

        System.out.println("Resultado: " + potencia(base, exponente));

       ;
    }

    public static double potencia(int base, int exponente) {
        double resultado = 1;

        if (exponente >= 0) {
            for (int i = 1; i <= exponente; i++) {
                resultado *= base;
            }
        } else { 
            for (int i = 1; i <= -exponente; i++) {
                resultado *= base;
            }
            resultado = 1 / resultado;
        }

        return resultado;
    }
}
