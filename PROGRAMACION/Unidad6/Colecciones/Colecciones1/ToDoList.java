package Colecciones1;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {

        ArrayList<String> tareas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Agregar Tarea | 2. Ver Tareas | 3. Eliminar Tarea | 4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Agregar Tarea: ");
                    String tarea = sc.next();
                    tareas.add(tarea);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Tareas: ");
                    for (int i = 0; i < tareas.size(); i++) {
                        System.out.println("-> " + tareas.get(i));
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Eliminar Tarea: ");
                    String tareaEliminar = sc.next();
                    tareas.remove(tareaEliminar);
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