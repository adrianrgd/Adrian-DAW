package Colecciones4.Ejercicio3;

public class App {
    public static void main(String[] args) {
        java.util.ArrayList<videojuego> listaVideojuegos = new java.util.ArrayList<>();

        listaVideojuegos.add(new videojuego("The Legend of Zelda", 95, 1986));
        listaVideojuegos.add(new videojuego("Super Mario Bros", 90, 1985));
        listaVideojuegos.add(new videojuego("Elden Ring", 96, 2022));
        listaVideojuegos.add(new videojuego("Halo", 87, 2001));
        listaVideojuegos.add(new videojuego("God of War", 94, 2018));

        System.out.println("Ordenado por puntuación (Comparable - Descendente):\n");
        java.util.Collections.sort(listaVideojuegos);
        for (videojuego v : listaVideojuegos) {
            System.out.println(v);
        }

        System.out.println("\nOrdenado por año y título (Comparator):");
        java.util.Collections.sort(listaVideojuegos, new CompararAño());
        for (videojuego v : listaVideojuegos) {
            System.out.println(v);
        }
    }

}
