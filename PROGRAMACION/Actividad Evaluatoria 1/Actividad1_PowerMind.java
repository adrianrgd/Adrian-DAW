import java.util.Scanner;

// Hola, soy novato y tengo necesidades especiales.
public class Actividad1_PowerMind {

    private static final Scanner sc = new Scanner(System.in);

    static int puntos = 0; // puntos acumulados
    static int partidasGanadas = 0;
    static int numeroIntentos = 0;
    static int partidasPerdidas = 0;
    static int partidasAbandonadas = 0;

    public static void menuOpciones() {
        System.out.println("==== ADIVINA LOS NUMEROS ====\n");
        boolean menu = true;
        // Bucle del menú principal que muestra las opciones elejibles. 
        while (menu) { // maneja las opciones y llama a las funciones correspondientes.
            try {
                System.out.println("Menú de opciones:");
                System.out.println("1. Iniciar juego.");
                System.out.println("2. Ver estadisticas.");
                System.out.println("3. Finalizar juego.");
                System.out.print("Opción: ");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> iniciarPartida();
                    case 2 -> verEstadisticas();
                    case 3 -> {
                        System.out.println("Gracias por jugar. ¡Hasta luego!");
                        menu = false;
                    }
                    default -> System.out.println("Elije una opción correcta.");
                }
            } catch (Exception e) {
                System.out.println("Excepción lanzada: " + e + " . Mensaje: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    private static boolean checkArrayDups(int[] array) {
        // Se revisa si hay numeros duplicados en el array
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true; // si hay duplicados
                }
            }
        }
        return false; // si no hay duplicados
    }

    private static int[] generarArrayNumeroAleatorio() {
        int[] array = new int[4];
        boolean check = true;
        while (check) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 10);
            }
            // Si no hay duplicados, se sale del bucle
            if (!checkArrayDups(array)) {
                check = false;
            }
        }

        return array;
    }


    // Arreglado
    private static void iniciarPartida() {
        int[] arrayNumeroSecreto = new int[4];
        int[] arrayNumeroAleatorio = generarArrayNumeroAleatorio();
        int intentos = 5;
        while (intentos != 0) {
            try {
                int numerosAnadidos = 0; // contamos cuántos números ha añadido el jugador
                while (numerosAnadidos != 4) {
                    System.out.println("Introduce el número secreto o -1 para salir");
                    int numeroSecreto = sc.nextInt();
                    if (numeroSecreto == -1) {
                        System.out.println("Programa Terminado!\n");
                        partidasAbandonadas++;
                        menuOpciones(); // regresa al menú principal
                    } else {
                        if (numeroSecreto >= 0 && numeroSecreto <= 9) {
                            arrayNumeroSecreto[numerosAnadidos] = numeroSecreto;
                            numerosAnadidos++;

                        } else {
                            System.out.println("Añade un número del 0 al 9.");
                        }
                    }
                }

                if (validarCifras(arrayNumeroSecreto, arrayNumeroAleatorio)) {
                    System.out.println("¡Enhorabuena, has acertado!");
                    // Asignamos puntos según cuántos intentos quedaban.
                    if (intentos <= 5 && intentos > 3) {
                        puntos += 3;
                    } else if (intentos <= 3 && intentos >= 1) {
                        puntos += 2;
                    } else {
                        puntos++;
                    }
                    partidasGanadas++;
                    intentos = 0; // salgo del bucle
                } else {
                    numeroIntentos++;
                    if (intentos == 1) {
                        partidasPerdidas++;
                        System.out.print("El número secreto era: ");
                        for (int i = 0; i < arrayNumeroAleatorio.length; i++) {
                            System.out.print(String.valueOf(arrayNumeroAleatorio[i]));
                        }
                        System.out.println("\nNo te quedan más intentos.\n");
                        intentos = 0; // salgo del bucle
                    } else {
                        intentos--;
                        System.out.println("Te quedan " + intentos + " intentos.\n");
                    }
                    
                }
            } catch (Exception e) {
                System.out.println("Excepción lanzada: " + e + " . Mensaje: " + e.getMessage());
                sc.nextLine();
            }
        }
        System.out.println("Volviendo al menú principal...\n");
    }

    private static void verEstadisticas() {
        // Muestra las estadísticas del juego
        System.out.println("\n¡Estadisticas de las partidas!\n");
        System.out.println("- Puntos: " + puntos);
        System.out.println("- Intentos: " + numeroIntentos);
        System.out.println("- Partidas Ganadas: " + partidasGanadas);
        System.out.println("- Partidas Perdidas: " + partidasPerdidas);
        System.out.println("- Partidas Abandonadas: " + partidasAbandonadas + "\n");
    }

    private static boolean validarCifras(int[] arrayNumeroSecreto, int[] arrayNumeroAleatorio) { // comprueba si los arrays son iguales
        // Conviertimos los arrays a cadenas para comparar más fácil.
        String validate1 = "";
        String validate2 = "";
        for (int i = 0; i < arrayNumeroAleatorio.length; i++) {
            validate1 += String.valueOf(arrayNumeroAleatorio[i]);
        }
        for (int i = 0; i < arrayNumeroSecreto.length; i++) {
            validate2 += String.valueOf(arrayNumeroSecreto[i]);
        }
        // Si no son iguales, ayudamos al jugador con pistas.
        if (!validate1.equals(validate2)) {
            checkPositions(arrayNumeroSecreto, arrayNumeroAleatorio, validate2);
            return false;
        } else {
            return true;
        }
    }

    private static void checkPositions(int[] arrayNumeroSecreto, int[] arrayNumeroAleatorio, String cifrasAdd) {
        System.out.println("No has acertado exactamente. Cifras añadidas: " + cifrasAdd);
        for (int i = 0; i < arrayNumeroAleatorio.length; i++) {
            for (int j = 0; j < arrayNumeroSecreto.length; j++) {
                if (arrayNumeroAleatorio[i] == arrayNumeroSecreto[j] && j != i) {
                    System.out.print("- Número " + arrayNumeroSecreto[j] + " está en otra posición.\n");
                } else if (arrayNumeroAleatorio[i] == arrayNumeroSecreto[j] && j == i) {
                    System.out.print("+ Número " + arrayNumeroSecreto[j] + " está en la posición correcta.\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        menuOpciones();
    }
}