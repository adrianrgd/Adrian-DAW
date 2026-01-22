package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ5_Aeropuerto;

public class Vuelo {
    private int codVuelo;
    private String origen;
    private String destino;
    private int capacidad;
    private int asientosDisponibles;


    public Vuelo(int codVuelo, String origen, String destino, int capacidad, int asientosDisponibles) {
        this.codVuelo = codVuelo;
        this.origen = origen;
        this.destino = destino;
        this.capacidad = capacidad;
        this.asientosDisponibles = asientosDisponibles;
    }

    public boolean ocuparAsientos(int numAsientos) {
        if (numAsientos <= this.asientosDisponibles) {
            this.asientosDisponibles -= numAsientos;
            return true;
        } else {
            return false;
        }
    }

    public void mostrarInformacionVuelo() {
        System.out.println("Vuelo " + codVuelo + ": " + origen + " -> " + destino);
        System.out.println("Asientos libres: " + asientosDisponibles + " de " + capacidad);
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }
    
    public int getCodVuelo() {
        return codVuelo;
    }
}