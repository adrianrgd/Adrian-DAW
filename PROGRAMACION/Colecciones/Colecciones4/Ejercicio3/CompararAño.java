package Colecciones4.Ejercicio3;

import java.util.Comparator;

public class CompararAño implements Comparator<videojuego> {
    @Override
    public int compare(videojuego o1, videojuego o2) {
        int comp = Integer.compare(o1.getAnyo(), o2.getAnyo());
        if (comp == 0) {
            return o1.getTitulo().compareTo(o2.getTitulo());
        }
        return comp;
    }
}
