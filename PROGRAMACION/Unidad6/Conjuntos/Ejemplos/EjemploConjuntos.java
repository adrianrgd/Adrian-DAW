import java.util.HashSet;
import java.util.Set;

public class EjemploConjuntos {
    public static void main(String[] args) {

        // Crea variable tipo Set, y asigna un objeto HashSet
        Set<String> miHashSet = new HashSet<>();

        if (miHashSet.add("Manzana")) {
            System.out.println("Primera manzana añadida");
        }

        // miHashSet.add("Manzana");
        miHashSet.add("Pera");
        miHashSet.add("Naranja");
        miHashSet.add("Manzana");

        System.out.println(miHashSet);

        if (!miHashSet.add("Manzana")) {
            System.out.println("Elemento duplicado");
        }

        System.out.println(miHashSet);

        // EJEMPLO CON PERSONA
        Set<Persona> SetPersonas = new HashSet<>();

        SetPersonas.add(new Persona("Ana", 25, "Madrid"));
        SetPersonas.add(new Persona("Luis", 30, "Barcelona"));
        SetPersonas.add(new Persona("Ana", 25, "Madrid"));
        SetPersonas.add(new Persona("Pablo", 27, "Valencia"));

        System.out.println(SetPersonas);
    }
}
