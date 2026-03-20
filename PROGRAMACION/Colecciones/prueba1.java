
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class prueba1 {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        // List<Integer> lista = new LinkedList<>();

        // Insertar en una posicion intermedia

        // momento inicial
        long inicio = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            lista.add(0, i);
        }

        // momento final
        long fin = System.nanoTime();
        System.out.println("Tiempo: " + (fin - inicio));
    }
}

// Tiempo ArrayList: 93623300 nanosegundos => 0.0936233 segundos
// Tiempo LinkedList: 3267200 nanosegundos => 0.0003267 segundos