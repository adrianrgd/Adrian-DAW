package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ5_Aeropuerto;

public class Reserva {
    private Vuelo vuelo;
    private Pasajero pasajero;
    private int numAsientos;

    public Reserva(Vuelo vuelo, Pasajero pasajero, int numAsientos) {
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.numAsientos = numAsientos;
    }

    public void procesarReserva() {
        System.out.println("\nProcesando reserva para " + pasajero.getNombre() + "...");
        
        boolean exito = vuelo.ocuparAsientos(numAsientos);

        if (exito) {
            System.out.println("¡Reserva confirmada! Se han reservado " + numAsientos + " asientos.");
        } else {
            System.out.println("No hay suficientes asientos disponibles. (Solicitados: " + numAsientos + ", Disponibles: " + vuelo.getAsientosDisponibles() + ")");
        }
    }
}
