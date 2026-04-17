package Colecciones1;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaContactos {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> telefonos = new ArrayList<>();

        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Agregar contacto");
            System.out.println("2. Ver contactos");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.next();
                    nombres.add(nombre);
                    System.out.print("Ingrese el telefono: ");
                    String telefono = sc.next();
                    telefonos.add(telefono);
                    break;
                case 2:
                    System.out.println("Contactos:");
                    for (int i = 0; i < nombres.size(); i++) {
                        System.out.println("-> " + nombres.get(i) + " - " + telefonos.get(i));
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBusqueda = sc.next();
                    for (int i = 0; i < nombres.size(); i++) {
                        if (nombres.get(i).equals(nombreBusqueda)) {
                            System.out.println("-> " + nombres.get(i) + " - " + telefonos.get(i));
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);
        sc.close();
    }

}
