package Ejercicios.EJ3;

public class App {
    public static void main(String[] args) {
        Vehiculo[] vehiculos = new Vehiculo[2];
        vehiculos[0] = new Coche("Kia");
        vehiculos[1] = new Bicicleta("Orbea");

        for (Vehiculo v : vehiculos) {
            v.mover();
        }
    }
}
