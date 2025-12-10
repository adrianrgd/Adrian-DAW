import java.util.Random;

public class Array3 {
    public static void main(String[] args) {
        int longitud = 10;
        int[] miArray = new int[longitud];
        
        //Generador de números aleatorios
        Random generador = new Random();
        int sumaTotal = 0;

        System.out.println("=== Array de 10 números aleatorios (1-100) ===");

        for (int i = 0; i < miArray.length; i++) {
            int numeroAleatorio = generador.nextInt(100) + 1;
        
            miArray[i] = numeroAleatorio;
            sumaTotal += numeroAleatorio;

            System.out.println("Índice " + i + ": " + miArray[i]);
        }

        System.out.println("\n=======================================");
        System.out.println("La Suma Total de los elementos es: " + sumaTotal);
    }
}
