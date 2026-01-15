//Ejercicio 4 POO_1

class Vehiculo {
    String tipo;
    int numRuedas;
    String estado;

    public Vehiculo(String tipo, int numRuedas, String estado) {
        this.tipo = tipo;
        this.numRuedas = numRuedas;
        this.estado = estado;
    }

    public void mostrarDetalles() {
        System.out.println("Tipo de vehiculo: " + tipo);
        System.out.println("Numero de ruedas: " + numRuedas);
        System.out.println("Estado: " + estado);
    }
}

public class MainVehiculo {
    public static void main(String[] args) {
        Vehiculo coche = new Vehiculo("Kia", 4, "Usado");
        coche.mostrarDetalles();
    }
}