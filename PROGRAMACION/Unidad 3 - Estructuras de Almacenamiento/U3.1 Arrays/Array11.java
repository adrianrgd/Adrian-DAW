import java.util.Scanner;

public class Array11 {
    public static void main(String[] args) {
        // 1. Rellenar el array de 5 posiciones con nombres de ciudades.
        String[] ciudadesArray = {"Madrid","Barcelona","Valencia","Sevilla","Bilbao"};
        Scanner teclado = new Scanner(System.in);
        String entradaUsuario;

        while (true) {
            System.out.print("Introduce un nombre de ciudad (o escribe 'salir' para terminar): ");
            entradaUsuario = teclado.nextLine();
            
            if (entradaUsuario.equalsIgnoreCase("salir")) {
                System.out.println("\n¡Hasta luego!");
                break;
            }

            boolean encontrada = false; 
            
            String ciudadBuscada = entradaUsuario.toLowerCase();

            for (String ciudad : ciudadesArray) {
                if (ciudad.toLowerCase().equals(ciudadBuscada)) {
                    encontrada = true;
                    break;
                }
            }
            
            if (encontrada) {
                System.out.println("**Ciudad encontrada** ✅");
            } else {
                System.out.println("**Ciudad no encontrada** ❌");
            } 
        }

        teclado.close();
    }
}