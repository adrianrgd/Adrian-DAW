//Ejercicio 1 POO_1

class Cine {
    String nombre;
    String ciudad;
    int antiguedad;

    public Cine(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = 0;
    }
}

public class MainCine {
    public static void main(String[] args) {
        Cine miCine = new Cine(null, null);
        miCine.nombre = "Cine Yelmo";
        miCine.ciudad = "Madrid";
        miCine.antiguedad = 12;

        System.out.println("Nombre del cine: " + miCine.nombre);
        System.out.println("Ciudad: " + miCine.ciudad);
        System.out.println("Antiguedad: " + miCine.antiguedad);
    }
}