import java.util.Scanner;

public class Aplicacion1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println(mostrarMenu("Convertir a USD", "Convertir a CAD", "Salir"));
            System.out.println("¿Qué opción eliges? ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> opcionElejida(opcion, teclado);
                case 2 -> opcionElejida(opcion, teclado);
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }

            if (opcion == 1 || opcion == 2) {
                System.out.println("¿Deseas volver al menú? (s/n)");
                String respuesta = teclado.next();
                if (!respuesta.equalsIgnoreCase("s")) {
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    teclado.close();
                    return;
                }
            }
        }
    }

    public static String mostrarMenu(String Opcion1, String Opcion2, String Opcion3) {
        System.out.println("\n=== MENU DE OPCIONES ===");
        System.out.println("Seleccione una de las siguientes opciones:");
        System.out.println("1) " + Opcion1);
        System.out.println("2) " + Opcion2);
        return "";
    }

    public static void opcionElejida(int opcion, Scanner tecladoOpcion) {
        System.out.println("Introduce el valor en EUROS: ");
        int valorEuros = tecladoOpcion.nextInt();

        if (validarEntrada(valorEuros)) {
            if (opcion == 1) {
                System.out.println(valorEuros + " EUR = " + conversor(valorEuros, 1.10) + " USD\n");
            } else if (opcion == 2) {
                System.out.println(valorEuros + " EUR = " + conversor(valorEuros, 1.47) + " CAD\n");
            }
        }
    }

    public static boolean validarEntrada(int valorEuro) {
        if (valorEuro < 0 || valorEuro > 10000) {
            System.out.println("Valor no válido, introduce un valor entre 0 y 10.000\n");
            return false;
        }
        return true;
    }

    public static double conversor(int valorEuro, double tasaCambio) {
        return valorEuro * tasaCambio;
    }
}
