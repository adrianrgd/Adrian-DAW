package Colecciones2;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        int num;

        do {
            System.out.println("Introduce un numero: ");
            num = Integer.parseInt(System.console().readLine());

            if (num == -1)
                break;

            numeros.add(num);

        } while (true);

        Iterator<Integer> it = numeros.iterator();
        System.out.println("Numeros Introducidos: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Pares
        it = numeros.iterator();
        System.out.println("\nNumeros Pares: ");
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) {
                System.out.print(numeros.get(i) + " ");
            }
        }

        // Multiplos 3
        it = numeros.iterator();
        System.out.println("\nMultiplos de 3: ");
        for (int j = 0; j < numeros.size(); j++) {
            if (numeros.get(j) % 3 == 0) {
                System.out.print(numeros.get(j) + " ");
            }
        }
    }
}
