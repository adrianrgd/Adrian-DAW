import java.util.Scanner;

public class Actividad1_PowerMind {

    //PROYECTO HECHO POR ADRIÁN RANGEL Y JAVIER SAN JUAN

    private static final Scanner sc = new Scanner(System.in);

    public static void init(int[] array) {
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
                    case 1 -> {
                        int[] arrayNumeroSecreto = new int[4];
                        int[] arrayNumeroAleatorio = generarArrayNumeroAleatorio();
                        int intentos = 5;
                        while (intentos != 0) {
                            try {
                                int numerosAnadidos = 0; // contamos cuántos números ha añadido el jugador
                                while (numerosAnadidos != 4) {
                                    System.out.print("Introduce un número (-1 para salir): ");
                                    int numeroSecreto = sc.nextInt();
                                    if (numeroSecreto == -1) {
                                        System.out.println("Programa Terminado!\n");
                                        array[4]++;
                                        init(array);
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
                                    // Asignamos los puntos según cuántos intentos quedaban.
                                    if (intentos <= 5 && intentos > 3) {
                                        array[0] += 3;
                                    } else if (intentos <= 3 && intentos >= 1) {
                                        array[0] += 2;
                                    } else {
                                        array[0]++;
                                    }
                                    array[1]++;
                                    intentos = 0; // salgo del bucle
                                } else {
                                    array[2]++;
                                    if (intentos == 1) {
                                        array[3]++;
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
                    case 2 -> {
                        // Muestra las estadísticas del juego
                        System.out.println("\n¡Estadisticas de las partidas!\n");
                        System.out.println("- Puntos: " + array[0]);
                        System.out.println("- Intentos: " + array[2]);
                        System.out.println("- Partidas Ganadas: " + array[1]);
                        System.out.println("- Partidas Perdidas: " + array[3]);
                        System.out.println("- Partidas Abandonadas: " + array[4] + "\n");
                    }
                    case 3 -> {
                        System.out.println("Gracias por jugar. ¡Hasta luego!");
                        menu = false;
                    }
                    default -> System.out.println("Elije una opción correcta.\n");
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

        for (int j = 0; j < arrayNumeroSecreto.length; j++) {
            boolean encontrado = false;

            for (int i = 0; i < arrayNumeroAleatorio.length; i++) {
                if (arrayNumeroAleatorio[i] == arrayNumeroSecreto[j]) {
                    encontrado = true;

                    if (i == j) {
                        System.out.println("+ Número " + arrayNumeroSecreto[j] + " está en la posición correcta.");
                    } else {
                        System.out.println("~ Número " + arrayNumeroSecreto[j] + " está en otra posición.");
                    }
                }
            }
            if (!encontrado) {
                System.out.println("- Número " + arrayNumeroSecreto[j] + " no aparece.");
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[5];
        init(array);
    }
}
