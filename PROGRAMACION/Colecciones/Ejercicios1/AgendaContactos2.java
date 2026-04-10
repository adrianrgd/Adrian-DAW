package Ejercicios1;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaContactos2 {
    public static void main(String[] args) {
        ArrayList<String[]> contactos = new ArrayList<>();

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
                    String[] nombre = new String[2];
                    nombre[0] = sc.next();
                    System.out.print("Ingrese el telefono: ");
                    nombre[1] = sc.next();
                    contactos.add(nombre);
                    break;
                case 2:
                    System.out.println("Contactos:");
                    for (int i = 0; i < contactos.size(); i++) {
                        System.out.println("-> " + contactos.get(i)[0] + " - " + contactos.get(i)[1]);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBusqueda = sc.next();
                    for (int i = 0; i < contactos.size(); i++) {
                        if (contactos.get(i)[0].equals(nombreBusqueda)) {
                            System.out.println("-> " + contactos.get(i)[0] + " - " + contactos.get(i)[1]);
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