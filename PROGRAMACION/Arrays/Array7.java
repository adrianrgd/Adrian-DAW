import java.util.Scanner;

public class Array7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Cuantos quieres guapo??: ");
        int longitud = teclado.nextInt();

        double sumaPositivos = 0;
        int contadorPositivos = 0;
        double sumaNegativos = 0;
        int contadorNegativos = 0;
        int contadorCeros = 0;
        
        for (int i = 0; i < longitud; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            int num = teclado.nextInt();
            
            if (num > 0) {
                contadorPositivos++;
            } else if (num < 0) {
                contadorNegativos++;
            } else {
                contadorCeros++;
            }
        }
        
        teclado.close();

        System.out.println("\n=== Resultados ===");
        
        if (contadorPositivos > 0) {
            double mediaPositivos = contadorPositivos;
            System.out.println("Media de positivos: " + mediaPositivos);
        } else {
            System.out.println("No se introdujeron números positivos.");
        }

        if (contadorNegativos > 0) {
            double mediaNegativos = contadorNegativos;
            System.out.println("Media de negativos: " + mediaNegativos);
        } else {
            System.out.println("No se introdujeron números negativos.");
        }
        
        System.out.println("Cantidad de ceros: " + contadorCeros);
    }
}


