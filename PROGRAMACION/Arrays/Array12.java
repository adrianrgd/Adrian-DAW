import java.util.Scanner;
import java.util.Arrays;

public class Array12 {
    public static void main(String[] args) {
        String[] ciudadesArray = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao", "Madrid", "Zaragoza", "Madrid"};
        Scanner teclado = new Scanner(System.in);
        String entradaUsuario;

        while (true) {
            System.out.print("Introduce un nombre de ciudad (o escribe 'salir' para terminar): ");
            entradaUsuario = teclado.nextLine();
            
            if (entradaUsuario.equalsIgnoreCase("salir")) {
                System.out.println("\n¡Hasta luego!");
                break;
            }

            int contador = 0;
            int primeraPosicion = -1;
            int ultimaPosicion = -1;
            
            String ciudadBuscada = entradaUsuario.toLowerCase();

            for (int i = 0; i < ciudadesArray.length; i++) {
                if (ciudadesArray[i].toLowerCase().equals(ciudadBuscada)) {
                    contador++;
                    
                    if (primeraPosicion == -1) {
                        primeraPosicion = i;
                    }
                    
                    ultimaPosicion = i;
                }
            }
            
            System.err.println("=======================");
            
            if (contador > 0) {
                System.out.println("Ciudad encontrada!");
                System.out.println("Veces que aparece: " + contador);
                System.out.println("Primera posición: " + primeraPosicion);
                System.out.println("Última posición: " + ultimaPosicion);
            } else {
                System.out.println("Ciudad no encontrada!");
            } 
            
            System.out.println("=======================");
        }

        teclado.close();
    }
}