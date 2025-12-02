import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Array11 {
    public static void main(String[] args) {

        List<String> ciudadesLista = new ArrayList<>();
        ciudadesLista.add("Bilbao");
        ciudadesLista.add("Albacete");
        ciudadesLista.add("Alicante");
        ciudadesLista.add("Almeria");
        ciudadesLista.add("Oviedo");
        ciudadesLista.add("Badajoz");
        ciudadesLista.add("Barcelona");
        ciudadesLista.add("Cadiz");
        ciudadesLista.add("Ciudad Real");
        ciudadesLista.add("A Coruña");
        ciudadesLista.add("Granada");
        ciudadesLista.add("Las Palmas");
        ciudadesLista.add("Leon");
        ciudadesLista.add("Madrid");
        ciudadesLista.add("Malaga");
        ciudadesLista.add("Murcia");
        ciudadesLista.add("Segovia");
        ciudadesLista.add("Sevilla");
        ciudadesLista.add("Tarragona");
        ciudadesLista.add("Toledo");
        ciudadesLista.add("Valencia");
        ciudadesLista.add("Valladolid");
        ciudadesLista.add("Zaragoza");

        int tamaño = 5;
        String arrayCiudades[] = new String[tamaño];
        boolean encontradas[] = new boolean[tamaño]; // Marcar los aciertos

        Random ciudadRandom = new Random();

        // Rellenar con ciudades aleatorias
        for (int i = 0; i < tamaño; i++) {
            int indiceAleatorio = ciudadRandom.nextInt(ciudadesLista.size());
            arrayCiudades[i] = ciudadesLista.get(indiceAleatorio);
            encontradas[i] = false; //Si no se adivinan
        }

        try (Scanner teclado = new Scanner(System.in)) {
            int aciertos = 0;

            System.out.println("========== JUEGO DE LAS CAPITALES =========");
            System.out.println("- Introduce una ciudad hasta acertar las 5!");
            System.out.println("- Escribe 'salir' para terminar el juego.");
            System.out.println("===========================================");

            while (true) {

                System.out.println("\nIntroduce una capital de provincia de España: ");
                String ciudadIntroducida = teclado.nextLine();

                if (ciudadIntroducida.equalsIgnoreCase("salir")) {
                    System.out.println("Te rendiste!! Programa Terminado");
                    break;
                }

                boolean acierto = false;

                // Comprobar si la ciudad introducida coincide con alguna aleatoria
                for (int i = 0; i < tamaño; i++) {
                    if (!encontradas[i] && arrayCiudades[i].equalsIgnoreCase(ciudadIntroducida)) {
                        encontradas[i] = true;
                        aciertos++;
                        acierto = true;
                        System.out.println("¡Ciudad Encontrada! (" + aciertos + "/5)");
                        break;
                    }
                }

                if (!acierto) {
                    System.out.println("Ciudad NO encontrada.");
                }

                // Si ya acertó las 5 ciudades → Fin del programa
                if (aciertos == tamaño) {
                    System.out.println("¡Has encontrado las 5 ciudades! Programa terminado.");
                    break;
                }
            }

            teclado.close();
        }
    }
}
