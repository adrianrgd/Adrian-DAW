
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class prueba2 {
    public static void main(String[] args) {
        // List<Integer> lista = new ArrayList<>();
        List<Integer> lista = new LinkedList<>();

        // Buscar en la lista por la posicion

        for (int i = 0; i < 100000; i++) {
            lista.add(i);
        }

        // momento inicial
        long inicio = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            lista.get(50000);
        }

        // momento final
        long fin = System.nanoTime();
        System.out.println("Tiempo: " + (fin - inicio));
    }
}

// Tiempo ArrayList: 149900 nanosegundos => 0.0001499 segundos
// Tiempo LinkedList: 668030000 nanosegundos => 0.66803 segundos
