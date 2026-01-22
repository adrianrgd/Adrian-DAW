package PROGRAMACION.Unidad_4_Programacion_Orientada_Objetos.U4_1_POO.Ejercicios_3.EJ5_Aeropuerto;

public class AppAeropuerto {
    public static void main(String[] args) {
        Vuelo v1 = new Vuelo(101, "Madrid", "Paris", 150, 123);
        v1.mostrarInformacionVuelo();

        Pasajero p1 = new Pasajero("Laura Gomez", "11223344A");
        Pasajero p2 = new Pasajero("Carlos Ruiz", "55667788B");

        Reserva r1 = new Reserva(v1, p1, 5);
        r1.procesarReserva();
        
        Reserva r2 = new Reserva(v1, p2, 30);
        r2.procesarReserva();

        System.out.println();
        v1.mostrarInformacionVuelo();
    }
}